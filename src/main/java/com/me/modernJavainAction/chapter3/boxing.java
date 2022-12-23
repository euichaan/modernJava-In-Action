package com.me.modernJavainAction.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

public class boxing {

  public static void main(String[] args) {
    IntPredicate evenNumbers = (int i) -> i % 2 == 0;
    System.out.println(evenNumbers.test(1000)); //참(박싱 없음)

    Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
    System.out.println(oddNumbers.test(1000)); //거짓(박싱)

    //==String.join()==//
    List<String> list = new ArrayList<>(Arrays.asList("java", "python", "kotlin"));
    String str = String.join(",", list);
    System.out.println(str);

    System.out.println("------------------------------------------------------");
    System.out.println(list.stream().collect(Collectors.joining(",")));

    String s = new String("      "); //nonWhitespace() == length()
    System.out.println(s.isBlank()); //문자열의 길이가 0인경우 + 문자열이 공백으로만 이루어져 있는 경우 비교하고 싶을 때 

    String s1 = new String(""); // nonWhitespace() = 0 == length = 0
    System.out.println(s.isBlank());

  }
}
