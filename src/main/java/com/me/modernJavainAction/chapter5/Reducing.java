package com.me.modernJavainAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//리듀싱 연산(모든 스트림 요소를 처리해서 값으로 도출)
public class Reducing {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
    int sum = numbers.stream()
        .reduce(0, Integer::sum);
    //BinaryOperator (T,T) -> T
    int product = numbers.stream()
        .reduce(1, (a, b) -> a * b);

    //초기값 없는 reduce
    Optional<Integer> NoIdentity = numbers.stream().reduce((a, b) -> (a + b));

    //최댓값
    Optional<Integer> max = numbers.stream()
        .reduce(Integer::max);

    //최솟값
    Optional<Integer> min = numbers.stream()
        .reduce(Integer::min);


  }
}
