package com.me.modernJavainAction.chapter8;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		String username = "bye";
		int num = 10;
		System.out.println("value: " + username + ", ref: " + Integer.toHexString(System.identityHashCode(username)));
		process1(username, num);

	}

	private static void process1(String username, int num) {
		username += "hello";
		System.out.println(username + " in process1");
		System.out.println("in process1 value: " + username + ", ref: " + Integer.toHexString(System.identityHashCode(username)));
		num += 1;
	}

	private static void process2(Map<String, Object> model) {
		model.put("members", "username");
	}

	private static void process3(StringBuilder list) {
		list.append("hello");
	}
}
