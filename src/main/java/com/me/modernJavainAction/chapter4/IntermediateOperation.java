package com.me.modernJavainAction.chapter4;

import static com.me.modernJavainAction.chapter4.Dish.*;

import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperation {
  public static void main(String[] args) {
    List<String> names = menu.stream()
        .filter(dish -> {
          System.out.println("filtering = " + dish.getName());
          return dish.getCalories() > 300;
        })
        .map(dish -> {
          System.out.println("mapping:" + dish.getName());
          return dish.getName();
        })
        .limit(3)
        .collect(Collectors.toList());
    System.out.println(names);

    System.out.println("-------------------");

    long count = menu.stream()
        .filter(d -> d.getCalories() > 300)
        .distinct() //중복되는 요소들은 모두 제거
        .limit(3)
        .count();
    System.out.println(count);
  }

}
