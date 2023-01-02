package com.me.modernJavainAction.chapter5;

import static com.me.modernJavainAction.chapter4.Dish.*;

import com.me.modernJavainAction.chapter4.Dish;
import com.me.modernJavainAction.chapter4.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {
  public static void main(String[] args) {
    List<Dish> vegetarianDishes = new ArrayList<>();
    for (Dish d : menu) {
      if (d.isVegetarian()){
        vegetarianDishes.add(d);
      }
    }

    System.out.println("Filtering with a predicate");
    List<Dish> vegetarianMenu = menu.stream()
        .filter(Dish::isVegetarian)
        .collect(Collectors.toList());

    //고유 요소 필터링
//    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//    numbers.stream()
//        .filter(i -> i % 2 == 0)
//        .distinct()
////        .forEach(i -> System.out.printf("%d ", i));
//        .forEach(Filtering::printWithSpace);
//    System.out.println();

    System.out.println("---------------------------------");

    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    numbers.stream()
        .filter(i -> i % 2 == 0)
        .distinct()
        .forEach(Filtering::printWithSpace); // T -> void

    System.out.println("---------------------------------");





    /**
     * 스트림 슬라이싱
     */
    //TAKEWHILE 활용
    List<Dish> specialMenu = Arrays.asList(
        new Dish("season fruit", true, 120, Type.OTHER),
        new Dish("prawns", false, 300, Type.FISH),
        new Dish("rice", true, 350, Type.OTHER),
        new Dish("chicken", false, 400, Type.MEAT),
        new Dish("french fries", true, 530, Type.OTHER));

    List<Dish> filteredMenu = specialMenu.stream()
        .filter(dish -> dish.getCalories() < 320)
        .collect(Collectors.toList());

    List<Dish> slicedMenu1 = specialMenu.stream()
        .takeWhile(dish -> dish.getCalories() < 320)
        .collect(Collectors.toList());

    System.out.println("---------------------");
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        .filter(n -> n % 2 == 0)
        .forEach(System.out::println);

    System.out.println("---------------------");
    Stream.of(2, 4, 3, 4, 5, 6, 7, 8, 9)
        .takeWhile(n -> n % 2 == 0)
        .forEach(System.out::println);

    List<Dish> slicedMenu2 = specialMenu.stream()
        .dropWhile(dish -> dish.getCalories() < 320)
        .collect(Collectors.toList());
    System.out.println(slicedMenu2);

    List<Dish> dishes = specialMenu.stream()
        .filter(dish -> dish.getCalories() > 300)
        .limit(3)
        .collect(Collectors.toList());

    List<Dish> skip = specialMenu.stream()
        .filter(d -> d.getCalories() > 300)
        .skip(2)
        .collect(Collectors.toList());

    //==스트림을 이용해서 처음 등장하는 두 고기 요리를 필터링하시오==//
    List<Dish> meat = menu.stream()
        .filter(d -> d.getType() == Type.MEAT)
        .limit(2)
        .collect(Collectors.toList());
    System.out.println(meat);

  }
  public static void printWithSpace(Integer i) {
    System.out.printf("%d ", i);
  }
}
