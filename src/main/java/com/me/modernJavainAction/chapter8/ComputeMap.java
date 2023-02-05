package com.me.modernJavainAction.chapter8;

import java.util.Objects;
import java.util.function.Function;

public interface ComputeMap {

	default V computeIfAbsent(K key,
		Function<? super K, ? extends V> mappingFunction) {
		Objects.requireNonNull(mappingFunction);
		V v;
		if ((v = get(key)) == null) { // 키가 존재하지 않으면
			V newValue; // 새로운 값 
			if ((newValue = mappingFunction.apply(key)) != null) { // Function 을 구현한 결과가 null이 아닐 때만
				put(key, newValue); // 맵에 추가
				return newValue;
			}
		}
		// 키가 존재하면
		return v; // 기존 값을 반환한다.
	}
}
