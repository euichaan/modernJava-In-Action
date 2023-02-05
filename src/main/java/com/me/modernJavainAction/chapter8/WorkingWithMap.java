package com.me.modernJavainAction.chapter8;

import static java.util.Map.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkingWithMap {
	public static void main(String[] args) {
		forEachWithMaps();
		sortWithMaps();
		getOrDefaultWithMaps();
		removingFromMaps();
		replacingInMaps();
		mergeMaps();
		computingOnMaps();
	}

	private static void forEachWithMaps() {
		System.out.println("--> Iterating a map with a for loop");
		Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
		for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
			String friendName = entry.getKey();
			Integer age = entry.getValue();
			System.out.println(friendName + " is " + age + " years old");
		}

		System.out.println("--> Iterating a map with forEach()"); // forEach
		ageOfFriends.forEach((friendName, age) -> System.out.println(friendName + " is " + age + " years old"));
	}

	private static void sortWithMaps() {
		System.out.println("--> Iterating a map sorted by keys through a Stream");
		Map<String, String> favouriteMovies = Map.ofEntries(
			entry("Raphael", "Star Wars"),
			entry("Cristina", "Matrix"),
			entry("Olivia", "James Bond"));
		favouriteMovies.entrySet()
			.stream()
			.sorted(Entry.comparingByKey())
			.forEachOrdered(System.out::println);
	}

	private static void getOrDefaultWithMaps() {
		System.out.println("--> Using getOrDefault()");
		Map<String, String> favouriteMovies = Map.ofEntries(
			entry("Raphael", "Star Wars"),
			entry("Cristina", "Matrix"),
			entry("Olivia", "James Bond"));
		System.out.println(favouriteMovies.getOrDefault("Olivia", "Matrix"));
		System.out.println(favouriteMovies.getOrDefault("Thibaut", "Matrix"));
	}

	private static void removingFromMaps() {
		System.out.println("--> Using overloading remove");
		Map<String, String> favouriteMovies = new HashMap<>();
		favouriteMovies.put("Raphael", "Jack Reacher 2");
		favouriteMovies.put("Cristina", "Matrix");
		favouriteMovies.put("Olivia", "James Bond");
		String key = "Raphael";
		String value = "Jack Reacher 2";

		favouriteMovies.remove(key, value);
		System.out.println(favouriteMovies);
	}

	private static void replacingInMaps() {
		Map<String, String> favouriteMovies = new HashMap<>();
		favouriteMovies.put("Raphael", "Star Wars");
		favouriteMovies.put("Olivia", "james bond");

		System.out.println("--> Replacing values in a map with replaceAll()");
		favouriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
		System.out.println(favouriteMovies);
		favouriteMovies.replace("Raphael", "hello");
		System.out.println(favouriteMovies);
	}

	private static void mergeMaps() {
		Map<String, String> family = Map.ofEntries(
			entry("Teo", "Star Wars"),
			entry("Cristina", "James Bond"));
		Map<String, String> friends = Map.ofEntries(entry("Raphael", "Star Wars"));

		System.out.println("--> Merging the old way");
		Map<String, String> everyone = new HashMap<>(family);
		everyone.putAll(friends);
		System.out.println(everyone);

		System.out.println("--> Merging maps using merge()");
		Map<String, String> friends2 = Map.ofEntries(
			entry("Raphael", "Star Wars"),
			entry("Cristina", "Matrix"));
		Map<String, String> everyone2 = new HashMap<>(family);
		friends2.forEach((k, v) -> everyone2.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
		System.out.println(everyone2);
	}

	private static void computingOnMaps() {
		Map<String, List<String>> friendsToMovies = new HashMap<>();

		System.out.println("--> Adding a friend and movie in a verbose way");
		String friend = "Raphael";

		friendsToMovies.computeIfAbsent("Raphael", name -> new ArrayList<>())
				.add("Star Wars");

		System.out.println(friendsToMovies);
	}
}
