package com.me.modernJavainAction.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 제네릭 형식 T를 인수로 받아서 제네릭 형식 R 객체를 반환하는 추상 메서드 apply를 정의합니다.
 * lambda expression 으로 함수형 인터페이스의 추상 메서드 구현을 직접 전달할 수 있으며
 * 전달된 코드는 함수형 인터페이스의 인스턴스로 전달된 코드와 같은 방식으로 처리됩니다.
 */
public class Functiontest {

  public static void main(String[] args) {
    List<Integer> length = map(Arrays.asList("lambdas", "in", "action"),
        (String s) -> s.length());

    System.out.println(length); //[7, 2, 6]
  }

  public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for (T t : list) { //파라미터로 넘어온 리스트를 돌면서
      result.add(f.apply(t));
    }
    return result;
  }

}
