package com.me.modernJavainAction.chapter8;

import static java.util.Map.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactoryMethod {
	public static void main(String[] args) {
		List<String> friends = new ArrayList<>();
		friends.add("Raphael");
		friends.add("Olivia");
		friends.add("Thibaut");

		/**
		 * 고정 크기의 리스트
		 * 요소 갱신할 수 있지만
		 * 추가, 삭제 불가능
		 */
		List<String> friendsList = Arrays.asList("Raphael", "Olivia", "Thibaut");
		friendsList.set(0, "chan");
		System.out.println(friendsList);

		Set<String> friendsSet = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));
		Set<String> collect = Stream.of("Raphael", "Olivia", "Thibaut")
			.collect(Collectors.toSet());
		// 내부적으로 불필요한 객체 할당을 필요로 한다.
		// 결과는 변환할 수 있는 집합이다.

		// 가변 인수 버전은 추가 배열을 할당해서 리스트로 감싼다. 배열을 할당하고 초기화하며 나중에 가비지 컬렉션을 하는 비용을 지불해야 한다.

		Set<String> friendsSet2 = Set.of("Raphael", "Olivia", "Thibaut");
		System.out.println(friendsSet2);

		// 열 개 이하의 키와 값 쌍을 가진 작은 맵을 만들 때는 이 메서드가 유용하다.
		Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);

		Map<String, Integer> ageOfFriendsMap = Map.ofEntries(entry("Raphael", 30),
			entry("Olivia", 25),
			entry("Thibaut", 26));
		// Map.entry 는 Map.Entry 객체를 만드는 새로운 팩토리 메서드이다.

		Map<String, List<String>> friendsToMovies = new HashMap<>();
		// 요소를 추가하려면 항목이 초기화되어 있는지 확인해야 한다.
		String friend = "Raphael";
		friendsToMovies.computeIfAbsent(friend, k -> new ArrayList<>())
				.add("Star Wars");

		System.out.println(friendsToMovies);
	}
}
