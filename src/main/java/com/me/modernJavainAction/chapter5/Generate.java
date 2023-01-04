package com.me.modernJavainAction.chapter5;

import java.util.function.IntSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generate {

  public static void main(String[] args) {

    /**
     * generate 로 fibonacci 만들기
     * supplier 에 상태를 저장. (병렬 코드애서는 not safe)
     */
    IntSupplier fib = new IntSupplier() {

      private int previous = 0;
      private int current = 1;

      @Override
      public int getAsInt() {
        //getAsInt 메서드의 연산을 커스터마이즈할 수 있는 상태 필드를 정의할 수 있다.
        int oldPrevious = this.previous;
        int nextValue = this.previous + this.current;
        this.previous = this.current;
        this.current = nextValue;
        return oldPrevious;
      }
    };
    IntStream.generate(fib)
        .limit(10)
        .forEach(System.out::println);
  }

}
