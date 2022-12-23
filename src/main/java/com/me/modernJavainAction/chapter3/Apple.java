package com.me.modernJavainAction.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Apple {

  private Color color;
  private Integer weight = 0;

  public Apple(Integer weight) {
    this.weight = weight;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  //==비공개 헬퍼 메서드==//
  private boolean isValidName(String string) {
    return Character.isUpperCase(string.charAt(0));
  }


  @SuppressWarnings("boxing")
  @Override
  public String toString() {
    return String.format("Apple{color=%s, weight=%d}", color, weight);
  }

  public static void main(String[] args) {
    List<Apple> list = new ArrayList<>(Arrays.asList(
        new Apple(Color.GREEN, 100),
        new Apple(Color.RED, 80),
        new Apple(Color.GREEN, 50)
    ));
    Collections.sort(list, new Comparator<Apple>() {
      @Override
      public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
      }
    });

  }
}
