package com.me.modernJavainAction.chapter5;

import static com.me.modernJavainAction.chapter4.Dish.*;

import com.me.modernJavainAction.chapter3.Apple;
import com.me.modernJavainAction.chapter4.Dish;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.boot.web.server.Cookie;

public class Mapping {

  public static void main(String[] args) {
    List<String> dishNames = menu.stream()
        .map(Dish::getName)//인수로 제공된 함수는 각 요소에 적용
        .collect(Collectors.toList());

    List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
    List<Integer> wordLengths = words.stream()
        .map(String::length)
        .collect(Collectors.toList());

    //각 요리명의 길이를 알고 싶을 때
    List<Integer> dishNameLengths = menu.stream()
        .map(Dish::getName)
        .map(String::length)
        .collect(Collectors.toList());

    List<String> stringList = Arrays.asList("Hello", "World");
    stringList.stream()
        .map(word -> word.split(""))
        .distinct()
        .collect(Collectors.toList());

    String[] arrayOfWords = {"Goodbye", "World"};
    Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

    //Arrays.stream -> 문자열을 받아 스트림을 만든다.
    List<Stream<String>> collect = words.stream()
        .map(word -> word.split(""))
        .map(Arrays::stream)
        .distinct()
        .collect(Collectors.toList());



    //flatMap 사용
    List<String> flatMap = words.stream()
        .map(word -> word.split(""))
        .flatMap(Arrays::stream)
        .distinct()
        .collect(Collectors.toList());

//    .map(word -> word.split("")) 각 단어를 개별 문자를 포함하는 배열로 변환
//    .flatMap(Arrays::stream) 생성된 스트림을 하나의 스트림으로 평면화

    //[1, 2, 3, 4, 5] 가 주어지면 [1, 4, 9, 16, 25] 반환
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> squares = numbers.stream()
        .map(n -> n * n) //인수로 제공된 함수는 각 요소에 적용되며, 함수를 적용한 결과가 새로운 요소로 매핑됩니다.
        .collect(Collectors.toList());


    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);

    List<int[]> pairs = numbers1.stream()
        .flatMap(i -> numbers2.stream()
            .map(j -> new int[]{i, j}))
        .collect(Collectors.toList());
    pairs.forEach(pair -> System.out.printf("(%d, %d) ", pair[0], pair[1]));

    System.out.println();
    System.out.println("--------------------------------------------------");

    List<int[]> pairsWithDividingThree = numbers1.stream()
        .flatMap(i -> numbers2.stream()
            .filter(j -> (i + j) % 3 == 0)
            .map(j -> new int[]{i, j}))
        .collect(Collectors.toList());

    pairsWithDividingThree.forEach(pair -> System.out.printf("(%d, %d) ", pair[0], pair[1]));

  }

}
