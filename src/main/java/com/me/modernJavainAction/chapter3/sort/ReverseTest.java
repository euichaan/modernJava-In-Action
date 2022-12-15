package com.me.modernJavainAction.chapter3.sort;

import java.util.Arrays;
import java.util.Comparator;

public class ReverseTest {

  public static void main(String[] args) {
    MyInteger[] arr = new MyInteger[10];

    for (int i = 0; i < 10; i++) {
      arr[i] = new MyInteger((int) (Math.random() * 100));
    }

    System.out.print("정렬 전 : ");
    for (int i = 0; i < 10; i++) {
      System.out.print(arr[i].value + " ");
    }
    System.out.println();

    Arrays.sort(arr, comp);

    System.out.print("정렬 후 : ");
    for (int i = 0; i < 10; i++) {
      System.out.print(arr[i].value + " ");
    }
    System.out.println();
    //String 클래스는 Comparable<String> 구현

  }

  public static Comparator<MyInteger> comp = new Comparator<MyInteger>() {
    @Override
    public int compare(MyInteger o1, MyInteger o2) {
      return o1.value - o2.value;
    }
  };

}

class MyInteger {
  int value;

  public MyInteger(int value) {
    this.value = value;
  }
}
