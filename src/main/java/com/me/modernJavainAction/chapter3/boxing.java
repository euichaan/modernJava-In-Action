package com.me.modernJavainAction.chapter3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

public class boxing {

  public static void main(String[] args) {
    IntPredicate evenNumbers = (int i) -> i % 2 == 0;
    System.out.println(evenNumbers.test(1000)); //참(박싱 없음)

    Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
    System.out.println(oddNumbers.test(1000)); //거짓(박싱)

  }
}
