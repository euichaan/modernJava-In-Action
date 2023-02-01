package com.me.modernJavainAction.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private static final long THRESHOLD = 10_000; // 이 값 이하의 서브태스크는 더 이상 분할할 수 없다.
	private final long[] numbers;
	private final int start; // 이 서브태크스에서 처리할 배열의 초기 위치
	private final int end; // 이 서브태스크에서 처리할 배열의 최종 위치

	public ForkJoinSumCalculator(long[] numbers) { // 메인 태스크를 생성할 때 사용할 공개 생성자
		this(numbers, 0, numbers.length);
	}

	private ForkJoinSumCalculator(long[] numbers, int start, int end) { // 메인 태스크의 서브태스크를 재귀적으로 만들 때 사용할 비공개 생성자
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		int length = end - start;
		if (length <= THRESHOLD) { // 기준값과 같거나 작으면 순차적으로 결과를 계산한다.
			return computeSequentially();
		}

		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
		leftTask.fork();

		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);

		Long rightResult = rightTask.compute();
		Long leftResult = leftTask.join();
		return leftResult + rightResult;
	}

	private long computeSequentially() {
		long sum = 0;
		for (int i = start; i < end; ++i) {
			sum += numbers[i];
		}
		return sum;
	}

	public long computeSequentiallyWithStream() {
		return Arrays.stream(numbers)
			.sum();
	}

	public static long forkJoinSum(long n) {
		// n까지의 자연수 덧셈 작업을 병렬로 수행하는 방법
		long[] numbers = LongStream.rangeClosed(1, n).toArray(); // 성능 저하
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}
}
