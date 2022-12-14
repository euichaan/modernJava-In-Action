package com.me.modernJavainAction.chapter3;

import static com.me.modernJavainAction.chapter3.Color.*;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

  public static void main(String[] args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, GREEN),
        new Apple(155, GREEN),
        new Apple(120, RED)
    );

    List<Apple> heavyApples = inventory.stream()
        .filter((Apple a) -> a.getWeight() > 150)
        .collect(toList());

    List<Apple> heavyApplesWithParallel = inventory.parallelStream()
        .filter((Apple a) -> a.getWeight() > 150)
        .collect(toList());

    Comparator<Apple> byWeight = new Comparator<Apple>() {
      @Override
      public int compare(Apple a1, Apple a2) {
        return Integer.compare(a1.getWeight(), a2.getWeight());
      }
    };

    Comparator<Apple> byWeightWithLambda = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();
   


  }

}
