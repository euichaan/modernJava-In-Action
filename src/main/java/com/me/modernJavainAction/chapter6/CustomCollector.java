package com.me.modernJavainAction.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.me.modernJavainAction.chapter1.methodtest.ArrayListTest;
import com.me.modernJavainAction.chapter6.dish.Dish;

public class CustomCollector {
	public static void main(String[] args) {
		Stream<Dish> stream = Dish.menu.stream();
		stream.collect(ArrayList::new, List::add, List::addAll);
	}
}
