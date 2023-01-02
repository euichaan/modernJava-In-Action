package com.me.modernJavainAction.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveCharacter {

  public static void main(String[] args) {
    List<Character> letters = new ArrayList<>();
    letters.addAll(Arrays.asList('A', 'B', '1', '2', 'C', 'D', '3', 'E', '4', '5'));

    //for (int i =0; i < 10; i++) {

    //Iterator의 remove
//    for (Iterator<Character> iter = letters.iterator(); iter.hasNext(); ) {
//      Character letter = iter.next();
//      if (Character.isDigit(letter)) {
//        iter.remove();
//      }
//    }

    //Java8 Stream
    letters.removeIf(Character::isDigit);

    List<Character> alphabets = letters.stream()
        .filter(Character::isAlphabetic)
        .collect(Collectors.toList());
    System.out.println(alphabets);


  }

}
