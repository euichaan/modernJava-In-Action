package com.me.modernJavainAction.chapter4;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LowCalories {

  public static final List<Dish> menu = Arrays.asList(
      new Dish("pork", false, 800, Type.MEAT),
      new Dish("beef", false, 700, Type.MEAT),
      new Dish("chicken", false, 400, Type.MEAT),
      new Dish("french fries", true, 530, Type.OTHER),
      new Dish("rice", true, 350, Type.OTHER),
      new Dish("season fruit", true, 120, Type.OTHER),
      new Dish("pizza", true, 550, Type.OTHER),
      new Dish("prawns", false, 400, Type.FISH),
      new Dish("salmon", false, 450, Type.FISH)
  );

  public static void main(String[] args) {
    /**
     * Java7
     */
    List<Dish> lowCaloricDishes = new ArrayList<>(); //'가비지 변수'
    for (Dish dish : menu) { //filtering
      if (dish.getCalories() < 400) {
        lowCaloricDishes.add(dish);
      }
    }
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() { //익명 클래스로 요리 정렬
      @Override
      public int compare(Dish dish1, Dish dish2) {
        return Integer.compare(dish1.getCalories(), dish2.getCalories());
      }
    });
    List<String> lowCaloricDishesName = new ArrayList<>();
    for (Dish dish : lowCaloricDishes) {
      lowCaloricDishesName.add(dish.getName());
    }
    System.out.println(lowCaloricDishesName);

    /**
     * Java8 Stream : 선언형(데이터를 처리하는 임시 구현 코드 대신 질의로 표현)
     */
    List<String> lowCaloricDishesNameWithStream =
        menu.stream()
            .filter(d -> d.getCalories() < 400) //400칼로리 이하의 요리 선택
            .sorted(comparing(Dish::getCalories)) //칼로리로 요리 정렬
            .map(Dish::getName)//요리명 추출
            .collect(Collectors.toList());
  }

}
