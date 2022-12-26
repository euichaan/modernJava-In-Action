package com.me.modernJavainAction.methodreference;

import static com.me.modernJavainAction.chapter3.Color.*;
import static java.util.Comparator.*;

import com.me.modernJavainAction.chapter3.Apple;
import com.me.modernJavainAction.chapter3.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Combination {
  public static void main(String[] args) {
    List<Apple> inventory = new ArrayList<>(Arrays.asList(
        new Apple(GREEN, 100),
        new Apple(RED, 80),
        new Apple(GREEN, 50)
    ));
    inventory.sort(comparing(Apple::getWeight).reversed());
//    inventory.sort(comparing(Apple::getWeight)
//        .reversed()
//        .thenComparing(Apple::getCountry));

    Predicate<Apple> redApple = (apple -> apple.getColor().name().equals("RED"));
    Predicate<Apple> notRedApple = redApple.negate(); //기존 프레디케이트 객체 redApple의 결과를 반전시킨 객체를 만든다.
    Predicate<Apple> readAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);
    Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(apple -> apple.getWeight() > 150)
        .or(apple -> GREEN.equals(apple.getColor()));

    Function<Integer, Integer> fa = x -> x + 1;
    Function<Integer, Integer> ga = x -> x * 2;
    Function<Integer, Integer> ha = fa.andThen(ga); //f를 먼저 적용한 결과를 g에 대입
    Integer result = ha.apply(1);
    System.out.println(result); // 4를 반환

    Function<Integer, Integer> f = x -> x + 1;
    Function<Integer, Integer> g = x -> x * 2;
    Function<Integer, Integer> h = f.compose(g); //g를 먼저 실행, 그 결과를 외부 함수의 인수로 제공
    Integer res = h.apply(1); // 3을 반환
    System.out.println(res);


  }

}
