package com.me.modernJavainAction.chapter6;

import static com.me.modernJavainAction.chapter6.dish.Dish.*;
import static java.util.stream.Collectors.*;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.me.modernJavainAction.chapter6.dish.Dish;

public class Reducing {
	public static void main(String... args) {
		System.out.println("Total calories in menu: " + calculateTotalCalories());
		System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
		System.out.println("Total menus count: " + countMenusByCustomCollector());
		System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
		System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
	}

	private static int calculateTotalCalories() {
		return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
	}

	private static int calculateTotalCaloriesWithMethodReference() {
		return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum)); // 초깃값, 변환 함수, 합계 함수
	}

	private static long countMenusByCustomCollector() {
		return menu.stream().collect(counting());
	}

	private static int calculateTotalCaloriesWithoutCollectors() {
		return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
	}

	private static int calculateTotalCaloriesUsingSum() {
		return menu.stream().mapToInt(Dish::getCalories).sum();
	}

	public static <T> Collector<T, ?, Long> counting() {
		return reducing(0L, e -> 1L, Long::sum);
	}

	private static Optional<Dish> calculateTotalCaloriesByOneArgument() {
		return menu.stream()
			.collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
	}

}
