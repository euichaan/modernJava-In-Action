package com.me.modernJavainAction.chapter5;

import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {
  public static void main(String[] args) {

    //Version 1
    Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a ->
            IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b ->
                    new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        );

    pythagoreanTriples.limit(5)
        .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2])); // T -> void

    //Version 2 : 최적화
    Stream<double[]> pythagoreanTriplesV2 = IntStream.rangeClosed(1, 100).boxed()
        .flatMap(a -> IntStream.rangeClosed(a, 100)
            .mapToObj(
                b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
            .filter(t -> t[2] % 1 == 0)); // 세 수의 세 번째 요소는 반드시 정수여야 한다.

  }

}
