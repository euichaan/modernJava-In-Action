package com.me.modernJavainAction.chapter3;

public class ValueOf {

  public static void main(String[] args) {
    try {
      int hi = Integer.parseInt("String value");
      System.out.println(hi);
    } catch (Exception e) {
      e.printStackTrace(); //NumberFormatException
    }

    try {
      Integer valueOfInt = Integer.valueOf("123");
      System.out.println(valueOfInt);
    } catch (Exception e) {
      e.printStackTrace();
    } //NumberFormatException

  }
}
