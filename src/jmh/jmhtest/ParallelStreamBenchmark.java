package jmhtest;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = { "-Xms4G", "-Xmx4G" })
@Measurement(iterations = 2)
@Warmup(iterations = 3)
public class ParallelStreamBenchmark {

	private static final long REPEAT_NUMBER = 10_000_000L;

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
			.include(ParallelStreamBenchmark.class.getSimpleName())
			.forks(2)
			.build();
		new Runner(opt).run();
	}

	@Benchmark
	public long iteraviteSum() {
		long result = 0;
		for (long i = 1L; i <= REPEAT_NUMBER; ++i) {
			result += i;
		}
		return result;
	}

	@Benchmark
	public long sequentialSum() {
		return Stream.iterate(1L, i -> i + 1)
			.limit(REPEAT_NUMBER)
			.reduce(0L, Long::sum);
	}

	@Benchmark
	public long rangedSum() {
		return LongStream.rangeClosed(1, REPEAT_NUMBER)
			.reduce(0L, Long::sum);
	}

	@Benchmark
	public long parallelSum() {
		return Stream.iterate(1L, i -> i + 1)
			.limit(REPEAT_NUMBER)
			.parallel()
			.reduce(0L, Long::sum);
	}

	@Benchmark
	public long parallelRangedSum() {
		return LongStream.rangeClosed(1, REPEAT_NUMBER)
			.parallel()
			.reduce(0L, Long::sum);
	}

	@TearDown(Level.Invocation) // 매 번 벤치마크를 실행한 다음에는 가비지 컬렉터 동작 시도
	public void tearDown() {
		System.gc();
	}

}
