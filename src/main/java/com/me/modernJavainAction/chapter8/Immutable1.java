package com.me.modernJavainAction.chapter8;

public class Immutable1 {
	public static void main(String[] args) {
		String name = "chan"; // String object is immutable
		name = "euichan";

		// 메모리상의 String Object의 값을 변경하는 것을 허용하지 않음.

		String one = "1";
		String temp = "1";
		String first = "1"; // 이상은 참조하는 위치가 같음

		String newOne = new String("1");
		printReference(one);
		printReference(temp);
		printReference(first);
		printReference(newOne);
	}
	static void printReference(String str) {
		System.out.println("value: " + str + ", ref: " + Integer.toHexString(System.identityHashCode(str)));
	}
}
