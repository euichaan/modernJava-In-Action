package com.me.modernJavainAction.chapter8;

import static java.util.Map.*;

import java.util.HashMap;
import java.util.Map;

public class MapFactory {
	public static void main(String[] args) {
		Map<String, Integer> ageOfFriends = of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

		ageOfFriends.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old"));

		Map<String, String> favouriteMovies = Map.ofEntries(
			entry("Raphael", "Star Wars"),
			entry("Cristina", "Matrix"),
			entry("Olivia", "James Bond"));

		favouriteMovies
			.entrySet()
			.stream()
			.sorted(Entry.comparingByKey())
			.forEachOrdered(System.out::println);

		// 키가 존재하더라도 값이 널인 상황에서는 getOrDefault 가 null 을 반환할 수 있다.
		System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
		System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));

		System.out.println("---------->Replace Pattern");
		Map<String, String> movies = new HashMap<>();
		movies.put("Raphael", "Star Wars");
		movies.put("Olivia", "james bond");

		movies.replace("Raphael", "Avengers");
		System.out.println(movies);
	}
}
