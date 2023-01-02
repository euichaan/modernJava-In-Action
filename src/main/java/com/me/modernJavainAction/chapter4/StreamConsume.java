package com.me.modernJavainAction.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConsume {
  public static void main(String[] args) {
    List<String> title = Arrays.asList("Java8", "In", "Action");
    Stream<String> s = title.stream();
    s.forEach(System.out::println);
    try {
      s.forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace(); // java.lang.IllegalStateException: stream has already been operated upon or closed
      //스트림이 이미 작동되었거나 닫혔습니다.
    }

    IntStream.range(1, 100).forEach(i -> {
      //로직
      if (i > 10) {
        return;
      }
      System.out.print(i + " ");
    });
    System.out.println();
    IntStream.range(1, 100)
        .filter(i -> i <= 50)
        .forEach(System.out::println);



  }

}
