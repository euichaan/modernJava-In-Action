package com.me.modernJavainAction.chapter5;

import static com.me.modernJavainAction.chapter4.Dish.*;

import com.me.modernJavainAction.chapter4.Dish;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
  public static void main(String[] args) {
//    int calories = menu.stream()
//        .map(Dish::getCalories)
//        .reduce(0, Integer::sum);

    //mapToInt
    //각 요리에서 모든 칼로리(Integer)를 추출한 다음에 IntStream 을 반환
    int calories = menu.stream()
        .mapToInt(Dish::getCalories)
        .sum();

    //객체 스트림으로 복원하기
    IntStream intStream = menu.stream()
        .mapToInt(Dish::getCalories);
    Stream<Integer> stream = intStream.boxed();


    OptionalInt maxCalories = menu.stream()
        .mapToInt(Dish::getCalories)
        .max();

    //최댓값이 없을 때 1
    int max = maxCalories.orElse(1);

    IntStream evenNumbers = IntStream.rangeClosed(1, 100) // [1,100]의 범위를 나타냅니다.
        .filter(n -> n % 2 == 0);
    System.out.println(evenNumbers.count()); //1부터 100까지에는 50개의 짝수가 있습니다.






  }
}
