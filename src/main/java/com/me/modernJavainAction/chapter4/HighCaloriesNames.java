package com.me.modernJavainAction.chapter4;

import static com.me.modernJavainAction.chapter4.Dish.*;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesNames {

  public static void main(String[] args) {
   List<String> threeHighCaloricDishNames =
       menu.stream() //메뉴(요리 리스트)에서 스트림을 얻는다. // Stream<Dish>
           .filter(dish -> dish.getCalories() > 300) //파이프라인 연산 만들기. 첫 번째로 고칼로리 요리 필터링 Stream<Dish>
           .map(Dish::getName) //요리명 추출 Stream<String>
           .limit(3)//선착순 세 개만 선택
           .collect(Collectors.toList()); //결과를 다른 리스트로 저장 List<String>
    System.out.println(threeHighCaloricDishNames); // [pork, beef, chicken]
  }

}
