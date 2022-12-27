package com.me.modernJavainAction.chapter4;

import java.util.Arrays;
import java.util.List;
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
  }

}
