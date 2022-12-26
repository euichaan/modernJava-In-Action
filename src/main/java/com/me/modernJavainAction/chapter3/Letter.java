package com.me.modernJavainAction.chapter3;

import java.util.function.Function;

public class Letter {
  public static String addHeader(String text) {
    return "From Raoul, Mario and Alan: " + text;
  }

  public static String addFooter(String text) {
    return text + " Kind regards";
  }

  public static String checkSpelling(String text) {
    return text.replaceAll("labda", "lambda"); //대상 문자열을 원하는 문자 값으로 변환하는 함수
    //replaceAll()은 정규표현식 사용이 가능합니다.
  }

  public static void main(String[] args) {
    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> transformationPipeline = addHeader.andThen(Letter::addFooter);
  }
}
