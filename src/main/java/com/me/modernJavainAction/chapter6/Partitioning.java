package com.me.modernJavainAction.chapter6;

import static com.me.modernJavainAction.chapter6.dish.Dish.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.me.modernJavainAction.chapter6.dish.Dish;
import com.me.modernJavainAction.chapter6.dish.Type;

public class Partitioning {
	public static void main(String[] args) {
		System.out.println("Dishes partitioned by vegetarian: " + partitionByVegetarian());
		System.out.println("Vegetarian Dishes by type: " + vegetarianDishesByType());
		System.out.println("Most caloric dishes by vegetarian: " + mostCaloricPartitionedByVegetarian());
		System.out.println("Number of Vegetarian and not Vegetarian: " + numberOfVegetarianDishes());

		Map<Boolean, List<Dish>> partitionedMenu = partitionByVegetarian();
		List<Dish> vegetarianDishes = partitionedMenu.get(true);
		List<Dish> vegetarianDishesSame = menu.stream().filter(Dish::isVegetarian).collect(toList());
	}

	private static Map<Boolean, Long> numberOfVegetarianDishes() {
		return menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
	}

	private static Map<Boolean, List<Dish>> partitionByVegetarian() {
		return menu.stream().collect(partitioningBy(Dish::isVegetarian));
	}

	private static Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType() {
		return menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
	}

	private static Object mostCaloricPartitionedByVegetarian() {
		return menu.stream().collect(
			partitioningBy(Dish::isVegetarian,
				collectingAndThen(
					maxBy(comparingInt(Dish::getCalories)),
					Optional::get)));
	}



}
