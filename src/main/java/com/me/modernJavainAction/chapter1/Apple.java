package com.me.modernJavainAction.chapter1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Apple {

  private int weight = 0;
  private String color = "";

  public static boolean isGreenApple(Apple apple) {
    return "green".equals(apple.getColor());
  }

  public static boolean isHeavyApple(Apple apple) {
    return apple.getWeight() > 150;
  }

  @Override
  public String toString() {
    return String.format("Apple{color='%s', weight=%d}", color, weight); //문자열의 형식을 설정하는 메서드
  }
}
