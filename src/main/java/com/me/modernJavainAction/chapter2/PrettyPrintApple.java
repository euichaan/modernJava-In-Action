package com.me.modernJavainAction.chapter2;

import static com.me.modernJavainAction.chapter2.Color.GREEN;
import static com.me.modernJavainAction.chapter2.Color.RED;

import java.util.Arrays;
import java.util.List;

public class PrettyPrintApple {

  public static void main(String[] args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, GREEN),
        new Apple(155, GREEN),
        new Apple(120, RED));

    prettyPrintApple(inventory, new AppleFancyFormatter());
  }
  public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
    for (Apple apple : inventory) {
      String output = formatter.accept(apple);
      System.out.println(output);
    }
  }

}
