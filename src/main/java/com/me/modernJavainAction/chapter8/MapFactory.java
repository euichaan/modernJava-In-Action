package com.me.modernJavainAction.chapter8;

import static java.util.Map.*;

import java.util.Map;

public class MapFactory {
	public static void main(String[] args) {
		// Map<String, Integer> ageOfFriends = of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
		// System.out.println(ageOfFriends);

		Map<String, Integer> ageOfFriends =
			Map.ofEntries(entry("Rapheal", 30),
				          entry("Olivia", 25),
			              entry("Thibaut", 26));
		System.out.println(ageOfFriends);



	}
}
