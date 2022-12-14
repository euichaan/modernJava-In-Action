package com.me.modernJavainAction.chapter3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter
@ToString
public class Player implements Comparable<Player> {
  private String name;
  private int score;

  @Override
  public int compareTo(Player o) {
    return o.getScore() - this.getScore(); //인자로 넘어온 객체 - 호출하는 객체
    // 양수 -> 현 객체와 대상 객체 교체
    // 0 -> 유지
    // 음수 -> 유지
  }

  public void hi() {
    System.out.println("hi");
  }
  public int hello() {
    return 1;
  }
}
