package com.me.modernJavainAction.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
			.limit(n)
			.reduce(0L, Long::sum);
	}

	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; ++i) {
			result += i;
		}
		return result;
	}

	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
			.limit(n)
			.parallel()
			.reduce(0L, Long::sum);
	}

	public static long rangedSum(long n) {
		return LongStream.rangeClosed(1, n)
			.reduce(Long::sum)
			.getAsLong();
	}

	public static long parallelRangedSum(long n) {
		return LongStream.rangeClosed(1, n)
			.parallel()
			.reduce(Long::sum)
			.getAsLong();
	}


	public static long sideEffectParallelSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
		return accumulator.total;
	}

	public static long sideEffectSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n).forEach(accumulator::add);
		return accumulator.total;
	}

	public static class Accumulator {
		private long total = 0;

		public void add(long value) {
			total += value;
		}
	}


}
