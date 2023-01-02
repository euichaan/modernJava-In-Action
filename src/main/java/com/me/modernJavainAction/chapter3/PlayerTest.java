package com.me.modernJavainAction.chapter3;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayerTest {

  public static void main(String[] args) {
    int[] scores = {899, 982, 1090, 982, 1018};
    System.out.println(Arrays.toString(scores));
    Arrays.sort(scores);
    System.out.println(Arrays.toString(scores));

    //특정 타입의 객체는 기본형 데이터와 달리 정렬 기준이 없으면 정렬 불가능.

    List<Player> players = new ArrayList<>();
    players.add(new Player("Alice", 899));
    players.add(new Player("Bob", 982));
    players.add(new Player("Chloe", 1090));
    players.add(new Player("Dale", 982));
    players.add(new Player("Eric", 1018));

    Collections.sort(players);
    System.out.println(players); // 내림차순 정렬

    // 정렬 하고자 하는 객체에 이미 존재하고 있는 정렬 기준과 다른 정렬 기준으로 정렬을 하고 싶을 때
    // 정렬 대상 클래스의 코드를 직접 수정할 수 없을 때
    Collections.sort(players, new Comparator<Player>() {
      //Comparable 구현 여부와 상관없이 compare() 기준으로 정렬 수행
      @Override
      public int compare(Player a, Player b) {
        return b.getScore() - a.getScore();
      }
    });

    players.stream()
        .sorted(comparing(Player::getScore).reversed())
        .forEach(System.out::println);


    Consumer<Player> hi = Player::hi;
    Function<Player, Integer> hello = Player::hello; //Function<T, R> T 받아서 R 반환

    System.out.println("-----------------------------------");

    players.stream()
        .sorted(comparing(Player::getScore)
            .thenComparing(Player::getName))
        .forEach(System.out::println);

  }
}
