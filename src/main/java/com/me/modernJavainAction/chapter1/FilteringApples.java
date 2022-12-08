package com.me.modernJavainAction.chapter1;

import static java.util.Comparator.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilteringApples {

  public static void main(String[] args) {

    List<Apple> inventory = Arrays.asList(
      new Apple(80, "green"),
      new Apple(155, "green"),
      new Apple(120, "red")
    );

    List<Apple> inventory2 = List.of(
        new Apple(80, "green"),
        new Apple(155, "green"),
        new Apple(120, "red")
    );

    //==첫 번째 방법==//
    Collections.sort(inventory, new Comparator<Apple>() {
      @Override
      public int compare(Apple a1, Apple a2) {
        return Integer.compare(a1.getWeight(), a2.getWeight());
      }
    });
    System.out.println(inventory);

    //==두 번째 방법==//
    inventory.sort(comparing(Apple::getWeight));

    System.out.println(inventory);

  }

}
