package com.me.modernJavainAction.chapter8;

import static java.util.Map.*;

import java.util.HashMap;
import java.util.Map;

public class MergeMap {
	public static void main(String[] args) {
		Map<String, String> family = Map.ofEntries(
			entry("Teo", "Star Wars"),
			entry("Cristina", "James Bond"));
		Map<String, String> friends = Map.ofEntries(entry("Raphael", "Star Wars"), entry("Cristina", "Matrix"));

		Map<String, String> everyone = new HashMap<>(family);
		friends.forEach((k, v) ->
			everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
		System.out.println(everyone);

		Map<String, Long> moviesToCount = new HashMap<>();
		String movieName = "JamesBond";
		moviesToCount.merge(movieName, 1L, Long::sum);

		System.out.println(moviesToCount);
	}
}
