package com.me.modernJavainAction.methodreference;

import com.me.modernJavainAction.chapter3.Apple;
import com.me.modernJavainAction.chapter3.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceTest {

  public static void main(String[] args) {
    Supplier<Apple> c1 = Apple::new; //() -> Apple(T) 와 같은 시그니처 갖는 생성자 있다고 가정.
    Apple a1 = c1.get();

    //Supplier<Apple> c1 = () -> new Apple();
    //Apple a2 = c1.get();

    Function<Integer, Apple> c2 = Apple::new;
    Apple a2 = c2.apply(110); // Function 의 apply 메서드에 무게를 인수로 호출해서 새로운 Apple 객체를 만들 수 있다.

    List<Integer> weights = Arrays.asList(7, 3, 4, 10);
    List<Apple> apples = map(weights, Apple::new);

    BiFunction<Color, Integer, Apple> c3 = Apple::new;
    Apple a3 = c3.apply(Color.GREEN, 110);
  }

  public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
    List<Apple> result = new ArrayList<>();
    for (Integer i : list) {
      result.add(f.apply(i));
    }
    return result;
  }

}
