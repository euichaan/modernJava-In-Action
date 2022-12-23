package com.me.modernJavainAction.methodreference;

import com.me.modernJavainAction.chapter3.Apple;
import com.me.modernJavainAction.chapter3.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceTest {

  public static void main(String[] args) {
    List<Apple> inventory = new ArrayList<>(Arrays.asList(
        new Apple(Color.GREEN, 100),
        new Apple(Color.RED, 80),
        new Apple(Color.GREEN, 50)
    ));
    inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    inventory.sort(Comparator.comparing(Apple::getWeight));

    List<String> str = Arrays.asList("a", "b", "A", "B");
    //Comparator의 compare는 (T,T) -> int
    str.sort(String::compareToIgnoreCase);

    //1
    Function<String, Integer> stringToInt = Integer::parseInt;

    //2
    BiPredicate<List<String>, String> contains = List::contains; //(List<String>, String) -> boolean

    //3
    Predicate<String> startsWithNumber = MethodReferenceTest::startsWithNumber;

    String numberString = new String("aa85");
    System.out.println(startsWithNumber(numberString));

  }
  private static boolean startsWithNumber(String string) {
    char[] charArray = string.toCharArray();
    if (Character.isDigit(charArray[0])) {
      return true;
    }
    else return false;
  }

}
