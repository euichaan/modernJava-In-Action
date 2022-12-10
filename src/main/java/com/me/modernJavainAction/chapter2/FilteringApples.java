package com.me.modernJavainAction.chapter2;

import static com.me.modernJavainAction.chapter2.Color.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FilteringApples {

  public static void main(String[] args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, GREEN),
        new Apple(155, GREEN),
        new Apple(120, RED));

    List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
    List<Apple> redApples = filterApplesByColor(inventory, RED);

    List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());

    List<Apple> redApplesWithAnonymousClass = filterApples(inventory, new ApplePredicate() {
      @Override
      public boolean test(Apple apple) {
        return RED.equals(apple.getColor());
      }
    });
    List<Apple> result = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));

    List<Integer> numbers = Arrays.asList(10, 2, 4);
    List<Integer> evenNumbers = filter(numbers , (Integer i) -> i % 2 == 0);
    inventory.sort(new Comparator<Apple>() {
      @Override
      public int compare(Apple a1, Apple a2) {
        return Integer.compare(a1.getWeight(), a2.getWeight());
      }
    });
    Thread t = new Thread(new Runnable() { //익명 클래스 : 클래스 선언과 인스턴스화 동시에
      @Override
      public void run() {
        System.out.println("hello");
      }
    });

    Thread lambda = new Thread(() -> System.out.println("hello"));
    ExecutorService executorService = Executors.newCachedThreadPool();
    Future<String> threadName = executorService.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        return Thread.currentThread().getName();
      }
    });

    Future<String> threadNameWithLambda = executorService.submit(() -> Thread.currentThread().getName());


  } //main END

  public static List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (GREEN.equals(apple.getColor())) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getColor().equals(color)) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getWeight() > weight) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApplesByWeight(List<Apple> inventory, Color color,
                                                  int weight, boolean flag) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
     if ((flag && apple.getColor().equals(color)) ||
         (!flag && apple.getWeight() > weight)) {
       result.add(apple);
     }
    }
    return result;
  }

  //==ApplePredicate 를 이용한 필터 메서드==//
  public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  public interface Predicate<T> {
    boolean test(T t);
  }

  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> result = new ArrayList<>();
    for (T e : list) {
      if (p.test(e)) {
        result.add(e);
      }
    }
    return result;
  }


}
