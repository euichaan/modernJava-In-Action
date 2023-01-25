package com.me.modernJavainAction.chapter1;

import static java.util.Comparator.*;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringApples {

  public static void main(String[] args) {

    List<Apple> inventory = Arrays.asList(
      new Apple(80, "green"),
      new Apple(155, "green"),
      new Apple(120, "red")
    );
//    inventory.add(new Apple(80, "green"));

    //==첫 번째 방법==//
    Collections.sort(inventory, new Comparator<Apple>() {
      @Override
      public int compare(Apple a1, Apple a2) {
        return Integer.compare(a1.getWeight(), a2.getWeight());
      }
    });
    //Comparable , Comparator
    //Comparable : compareTo(T o1)
    //Comparator : compare(T o1, T o2)
    System.out.println(inventory);


    //==두 번째 방법==//
    inventory.sort(comparing(Apple::getWeight));

    System.out.println(inventory);

    File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        return file.isHidden();
      }
    });

    File[] hiddenFilesWithMethodReference = new File(".").listFiles(File::isHidden);

    //==method reference==//
    filterApples(inventory, Apple::isGreenApple);
    filterApples(inventory, Apple::isHeavyApple);


    //==lambda==//
    filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
    filterApples(inventory, (Apple a) -> a.getWeight() > 150);
    filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "red".equals(a.getColor()));

    List<Apple> heavyApples =
        inventory.parallelStream()
        .filter((Apple a) -> a.getWeight() > 150)
        .collect(Collectors.toList());

    List<Apple> heavyApplesWithStreamToList =
        inventory.parallelStream()
        .filter(Apple::isGreenApple).collect(Collectors.toList());

    List<String> words = new ArrayList<>();


  } // main END

  private boolean isValidName(String string) {
    return Character.isUpperCase(string.charAt(0));
  }

  public static List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if ("green".equals(apple.getColor())) {
        result.add(apple);
      }
    }
    return result;
  }
  public static List<Apple> filterHeavyApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if (apple.getWeight() > 150) {
        result.add(apple);
      }
    }
    return result;
  }

  public static boolean isGreenApple(Apple apple) {
    return "green".equals(apple.getColor());
  }

  public static boolean isHeavyApple(Apple apple) {
    return apple.getWeight() > 150;
  }

  public interface Predicate<T> {
    boolean test(T t);
  }

  //람다 -> 함수형 인터페이스를 인수로 받는 메서드로 전달할 수 있다
  static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
    //메서드가 p라는 이름의 프레디케이트 파라미터로 전달됨.
    List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if (p.test(apple)) { //사과는 p가 제시하는 조건에 맞는가?
        result.add(apple);
      }
    }
    return result;
  }
}
