package com.me.modernJavainAction.chapter4;

import static com.me.modernJavainAction.chapter4.Dish.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamVsCollection {
  public static void main(String[] args) {
//    List<String> names = new ArrayList<>();
//    for (Dish dish : menu) {
//      names.add(dish.getName());
//    }

   //컬렉션 : 내부적으로 숨겨졌던 반복자를 사용한 외부 반복
    List<String> highCaloricDishes = new ArrayList<>();
    Iterator<Dish> iterator = menu.iterator();
    while (iterator.hasNext()) {
      Dish dish = iterator.next();
      if (dish.getCalories() > 300) {
        highCaloricDishes.add(dish.getName());
      }
    }

    menu.stream()
        .filter(dish -> dish.getCalories() > 300)
        .map(Dish::getName)
        .collect(Collectors.toList());






  } //main END


}
