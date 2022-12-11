package com.me.modernJavainAction.methodtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSortTest {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(3, 1, 5, 4, 2, 7);
    list.sort(null); // null이 무엇을 의미..?
    System.out.println(list);

    Collections.sort(list);
    System.out.println(list);



  }

}
