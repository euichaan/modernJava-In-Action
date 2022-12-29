package com.me.modernJavainAction.chapter5;

import static com.me.modernJavainAction.chapter4.Dish.*;

import com.me.modernJavainAction.chapter4.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Finding {

  public static void main(String[] args) {
    if (menu.stream().anyMatch(Dish::isVegetarian)) {
      System.out.println("The meu is (somewhat) vegetarian friendly!!");
    }

    boolean isHealthy = menu.stream()
        .allMatch(dish -> dish.getCalories() < 1000);

    boolean isHealthWithNoneMatch = menu.stream()
        .noneMatch(d -> d.getCalories() >= 1000);

    Optional<Dish> dish = menu.stream()
        .filter(Dish::isVegetarian)
        .findAny();

    menu.stream()
        .filter(Dish::isVegetarian)
        .findAny()
        .ifPresent(dish1 -> System.out.println(dish1.getName()));

    List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
    Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
        .map(n -> n * n)
        .filter(n -> n % 3 == 0)
        .findFirst();

    System.out.println(firstSquareDivisibleByThree.orElseThrow(NoSuchElementException::new));


  }
}
