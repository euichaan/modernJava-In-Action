package com.me.modernJavainAction.chapter8;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
		map.put("5", 5L);
		long parallelismThreshold = 1;
		Optional<Long> maxValue = Optional.ofNullable(map.reduceValues(parallelismThreshold, Long::max));
		System.out.println(maxValue.get());
		ConcurrentHashMap.KeySetView<String, Long> strings = map.keySet();
	}
}
