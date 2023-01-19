package com.me.modernJavainAction.chapter6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PartitionPrimeNumbers {

	public static void main(String[] args) {
		System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
		System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimesWithCustomCollector(100));
		Map<Boolean, List<Integer>> partitionPrimeList = partitionPrimes(10);
		System.out.println(partitionPrimeList);
	}
	public static boolean isPrime(List<Integer> primes, int candidate) {
		int candidateRoot = (int)Math.sqrt(candidate);
		return primes.stream().
			takeWhile(i -> i <= candidateRoot)
			.noneMatch(i -> candidate % i == 0);
	}
	public static boolean isPrime(int candidate) {
		int candidateRoot = (int)Math.sqrt(candidate); // 에라토스테네스의 체
		return IntStream.rangeClosed(2, candidateRoot)
			.noneMatch(i -> candidate % i == 0);
	}

	public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
		return IntStream.rangeClosed(2, n).boxed()
			.collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
	}

	public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
	}

	public Map<Boolean, List<Integer>> partitionPrimesWithInlineCollector(int n) {
		return Stream.iterate(2, i -> i + 1).limit(n)
			.collect(
				() -> new HashMap<Boolean, List<Integer>>() {{
					put(true, new ArrayList<Integer>());
					put(false, new ArrayList<Integer>());
				}},
				(acc, candidate) -> {
					acc.get(isPrime(acc.get(true), candidate))
						.add(candidate);
				},
				(map1, map2) -> {
					map1.get(true).addAll(map2.get(true));
					map1.get(false).addAll(map2.get(false));
				}
			);
	}

}
