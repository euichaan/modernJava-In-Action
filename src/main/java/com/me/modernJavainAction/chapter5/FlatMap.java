package com.me.modernJavainAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

  public static void main(String[] args) {
    List<String> words = Arrays.asList("Hello", "World");
    List<String[]> v1 = words.stream()
        .map(word -> word.split(""))
        .distinct()
        .collect(Collectors.toList());

    String[] arrayOfWords = {"Goodbye", "World"};
    Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

    List<Stream<String>> v2 = words.stream()
        .map(word -> word.split(""))
        .map(Arrays::stream)
        .distinct()
        .collect(Collectors.toList());

    List<String> v3 = words.stream()
        .map(word -> word.split("")) //각 단어를 개별 문자를 포함하는 배열로 변환
        .flatMap(Arrays::stream) //생성된 스트림을 하나의 스트림으로 평면화
        .distinct()
        .collect(Collectors.toList());


  }

}
