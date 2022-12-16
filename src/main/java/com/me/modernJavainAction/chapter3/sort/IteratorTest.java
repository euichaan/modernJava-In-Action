package com.me.modernJavainAction.chapter3.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IteratorTest {

  public static void main(String[] args) {
    List<Character> letters = new ArrayList<>(
        Arrays.asList('A', 'B', '1', '2', 'C', 'D', '3', 'E', '4', '5'));

//    for (Iterator<Character> iter = letters.iterator(); iter.hasNext(); ) {
//      Character letter = iter.next();
//      if (Character.isDigit(letter)) {
//        iter.remove(); //숫자 원소 제거
//      }
//    }

    for (Iterator<Character> iter = letters.iterator(); iter.hasNext();) {
      Character letter = iter.next();
      if (Character.isDigit(letter)) {
        iter.remove();
      }
    }
//    List<Character> letters = new ArrayList<>(
//        Arrays.asList('A', 'B', '1', '2', 'C', 'D', '3', 'E', '4', '5'));
//
//    List<Character> alphabets = letters.stream()
//        .filter(Character::isAlphabetic)
//        .collect(Collectors.toList());


  }

}
