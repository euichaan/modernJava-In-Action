package com.me.modernJavainAction.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer<T>
 * 제네릭 형식 T 객체를 받아서 void를 반환하는 accept라는 추상 메서드를 정의
 */
public class ConsumerTest {

  public static void main(String[] args) {
    forEach(Arrays.asList(1, 2, 3, 4, 5),
        (Integer i) -> System.out.println(i)); //Consumer의 accept를 구현하는 람다
  }

  public static <T> void forEach(List<T> list, Consumer<T> c) {
    for (T t : list) {
      c.accept(t);
    }
  }
}
