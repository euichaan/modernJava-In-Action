package com.me.modernJavainAction.chapter8;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
	// Key는 중복저장 불가, Value는 중복 가능
	// Key, Value 한 쌍 -> Map.Entry
	// List, Set 과 다른 interface
	// KeySet() : key들만 뽑아서 Set 객체로 리턴
	// entrySet() : Entry들을 Set 객체로 담아 리턴. Set<Entry<K,V>>
	// Key가 Set으로 관리.
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		map.put(2, "나다라");
		map.put(1, "가나다");
		map.put(3, "다라마");

		System.out.println(map);

		System.out.println(map.containsValue("나다라"));

		Set<Integer> keySet = map.keySet();
		System.out.println(keySet);

		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		System.out.println(entrySet);

	}
}
