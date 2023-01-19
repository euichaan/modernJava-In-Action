package com.me.modernJavainAction.chapter6;

import java.util.Optional;

import com.me.modernJavainAction.chapter4.Dish;

public class OptionalEmpty {
	public static void main(String[] args) {
		Optional<Dish> dishOptional = Optional.empty();
		System.out.println(dishOptional);
	}
}
