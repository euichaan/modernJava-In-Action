package com.me.modernJavainAction.methodreference;

import com.me.modernJavainAction.chapter3.Apple;
import com.me.modernJavainAction.chapter3.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

  public static void main(String[] args) {
    List<Apple> list = new ArrayList<>(Arrays.asList(
        new Apple(Color.GREEN, 100),
        new Apple(Color.RED, 80),
        new Apple(Color.GREEN, 50)
    ));
    list.sort(new AppleComparator());//sort의 동작은 파라미터화되었음.
    list.sort(new Comparator<Apple>() {
      // (T, T) -> int
      // 우리의 경우 (Apple, Apple) -> int
      @Override
      public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
      }
    });
    list.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

  }
}
class AppleComparator implements Comparator<Apple> {

  @Override
  public int compare(Apple a1, Apple a2) {
    return a1.getWeight().compareTo(a2.getWeight());
  }
}
