package com.me.modernJavainAction.chapter5;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    //1번 : 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
    List<Transaction> practice1 = transactions.stream()
        .filter(year -> year.getYear() == 2011)
        .sorted(comparing(Transaction::getValue))
        .collect(toList());
    System.out.println("practice 1 " + practice1);

    //2번 : 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
    List<String> practice2 = transactions.stream()
        .map(Transaction::getTrader)
        .map(Trader::getCity)
        .distinct()
        .collect(toList());
    System.out.println("practice 2 " + practice2);

    //2번 추가
    transactions.stream()
        .map(transaction ->  transaction.getTrader().getCity())
        .distinct()
        .collect(toList());

    //3번 : 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
    List<Trader> practice3 = transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> trader.getCity().equals("Cambridge"))
        .distinct()
        .sorted(comparing(Trader::getName))
        .collect(toList());
    System.out.println("practice 3 " + practice3);

    //4번 : 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
    String practice4 = transactions.stream()
        .map(transaction -> transaction.getTrader().getName())
        .distinct()
        .sorted()
        .reduce("", (n1, n2) -> n1 + n2 + " ");
    System.out.println("practice 4 " + practice4);

    //4번 joining 즉, StringBuilder 이용
    transactions.stream()
        .map(transaction -> transaction.getTrader().getName())
        .distinct()
        .sorted()
        .collect(joining());

    //5번 : 밀라노에 거래자가 있는가?
    boolean milanBased = transactions.stream()
        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    System.out.println("practice 5 " + milanBased);

    //6번 : 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
    System.out.print("practice 6 ");
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(Transaction::getValue)
        .forEach(i -> System.out.printf("%d ", i));
    System.out.println();

    //7번 : 전체 트랜잭션 중 최댓값은 얼마인가?
    Optional<Integer> practice7 = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::max);
    System.out.println("practice 7 " + practice7.orElseThrow(NoSuchElementException::new));

    //8번 : 전체 트랜잭션 중 최솟값은 얼마인가?
    Optional<Integer> practice8 = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::min);
    System.out.println("practice 8 " + practice8.orElseThrow(NoSuchElementException::new));

    //8번 : 람다 사용
    Optional<Transaction> practice88 = transactions.stream()
        .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

    Optional<Transaction> min = transactions.stream()
        .min(comparing(Transaction::getValue));

  } //main END

}
