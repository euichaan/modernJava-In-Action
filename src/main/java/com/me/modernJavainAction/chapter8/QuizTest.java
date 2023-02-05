package com.me.modernJavainAction.chapter8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QuizTest {
	public static void main(String[] args) {
		Map<String, Integer> movies = new HashMap<>();
		movies.put("JamesBond", 20);
		movies.put("Matrix", 15);
		movies.put("Harry Porter", 5);

		// Iterator<Map.Entry<String, Integer>> iterator = movies.entrySet().iterator();
		// while (iterator.hasNext()) {
		// 	Map.Entry<String, Integer> entry = iterator.next();
		// 	if (entry.getValue() < 10) {
		// 		iterator.remove();
		// 	}
		// }

		movies.entrySet()
			.removeIf(entry -> entry.getValue() < 10);

		System.out.println(movies);
	}
}
