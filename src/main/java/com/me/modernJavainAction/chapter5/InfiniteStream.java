package com.me.modernJavainAction.chapter5;

import java.util.stream.Stream;

public class InfiniteStream {

  public static void main(String[] args) {
    //UnaryOperator T -> T
    Stream.iterate(0,  n -> n + 2)
        .limit(10)
        .forEach(System.out::println); //Stream 소비

    //Fibonacci
//    Stream.iterate(new int[]{0, 1}, ???) iterate 는 ??? 자리에 주어지는 람다를 연속적으로 적용하는 함수
//        .limit(20)
//        .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    Stream.iterate(new int[]{0, 1},
        t -> new int[]{t[1], t[0] + t[1]}) // (3,5) 다음은 (5,8) 이므로 t[1], t[0] + t[1]이 온다.
        .limit(10)
        .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

    //일반적인 피보나치 수열
    Stream.iterate(new int[]{0, 1},
            t -> new int[]{t[1], t[0] + t[1]}) // (3,5) 다음은 (5,8) 이므로 t[1], t[0] + t[1]이 온다.
        .limit(10)
        .map(t -> t[0])
        .forEach(t -> System.out.printf("%d ", t));

    Stream.iterate(0, n -> n < 100, n -> n + 4)
        .forEach(System.out::println);

    Stream.iterate(0, n -> n + 4)
        .filter(n -> n < 100)
        .forEach(System.out::println);


  }

}
