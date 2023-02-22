package com.me.modernJavainAction.chapter8;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ReplaceAll {
	public static void main(String[] args) {
		List<String> referenceCodes = Arrays.asList("a12", "C14", "b13");
		referenceCodes.stream()
			.map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
			.collect(Collectors.toList())
			.forEach(System.out::println); // 새 문자열 컬렉션을 만든다.

		for (ListIterator<String> iterator = referenceCodes.listIterator();
			 iterator.hasNext();) {
			String code = iterator.next();
			iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
		}

		referenceCodes.replaceAll(code ->
			Character.toUpperCase(code.charAt(0)) + code.substring(1));
	}
}
