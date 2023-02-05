package com.me.modernJavainAction.chapter8;

import static java.util.Map.*;

import java.util.List;
import java.util.Map;

public class MapFactory {
	public static void main(String[] args) {
		// Map<String, Integer> ageOfFriends = of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
		// System.out.println(ageOfFriends);
 		// immutable : 불변. 변경할 수 없음
		List<String> hello = List.of("hello");
		try {
			hello.add("hi");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
	}


}
