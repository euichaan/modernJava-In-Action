package com.me.modernJavainAction.chapter5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ComparableTest {
  public static void main(String[] args) {
    String[] s = new String[]{"hello", "my", "name", "is", "euichan"};
    Arrays.sort(s);

    for (int i = 0 ; i < s.length; i++) {
      System.out.println(s[i]);
    }
    System.out.println("-----------------------------------");

    Set<String> set = new TreeSet<>();
    Collections.addAll(set, args);
    System.out.println(set);
  }
}
