package com.me.modernJavainAction.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lazy {

  public static void main(String[] args) {
    final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println(
        list.stream()
            .filter(i -> {
              System.out.println("i < 6");
              return i < 6;
            })
            .filter(i -> {
              System.out.println("i%2 == 0");
              return i%2==0;
            })
            .map(i -> {
              System.out.println("i = i*10");
              return i*10;
            })
            .collect(Collectors.toList()) //최종 연산
    );
  }
}
