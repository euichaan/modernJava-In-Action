package com.me.modernJavainAction.chapter3;


import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate<T>
 * test라는 추상 메서드를 정의하며 test는 제네릭 형식 T의 객체를 인수로 받아 불리언을 반환합니다.
 * T 형식의 객체를 사용하는 불리언 표현식이 필요힌 상황에서 Predicate 인터페이스를 사용할 수 있다.
 */
public class PredicateTest {

  public static void main(String[] args) {

    List<String> listOfStrings = new ArrayList<>(List.of("hello"));

    Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
    List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
    System.out.println(nonEmpty);
  }

  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> results = new ArrayList<>();
    for (T t : list) {
      if (p.test(t)) {
        results.add(t);
      }
    }
    return results;
  }

}
