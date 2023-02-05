package com.me.modernJavainAction.chapter8;

import java.util.HashMap;
import java.util.Map;

public class MergeTest {
	public static void main(String[] args) {
		watchMovieCount();
	}

	private static void watchMovieCount() {
		Map<String, Long> moviesToCount = new HashMap<>();
		String movieName = "JamesBond";
		moviesToCount.merge(movieName, 1L, (key, count) -> count + 1L);
		System.out.println(moviesToCount);
	}

}
