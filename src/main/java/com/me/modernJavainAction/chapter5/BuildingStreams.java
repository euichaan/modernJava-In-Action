package com.me.modernJavainAction.chapter5;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 5.8 BuildingStreams
 */
public class BuildingStreams {
  public static void main(String[] args) {
    Stream<String> strings = Stream.of("Modern ", "Java ", "In ", "Action ");
    strings.map(String::toUpperCase).forEach(System.out::println);

    String homeValue = System.getProperty("home");
    Stream<String> homeValueStream
        = homeValue == null ? Stream.empty() : Stream.of(homeValue);

    //ofNullable 사용해서 Stream 만들기
    Stream<String> homeValueStreamWithNullable
        = Stream.ofNullable(System.getProperty("home"));

    Stream<String> values = Stream.of("config", "home", "user")
        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

    int[] numbers = {2, 3, 5, 7, 11, 13};
    int sum = Arrays.stream(numbers).sum(); //합계는 41

  }
}
