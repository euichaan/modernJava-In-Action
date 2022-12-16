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

    Runnable r1 = () -> System.out.println("Hello World 1 "); // 람다 사용
    Runnable r2 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello World 2");
      }
    };
    process(r1);
    process(r2);
    process(() -> System.out.println("Hello World3"));
  }
  public static void process(Runnable r) {
    r.run();
  }

}
