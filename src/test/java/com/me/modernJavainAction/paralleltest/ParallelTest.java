package com.me.modernJavainAction.paralleltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.me.modernJavainAction.chapter3.Apple;
import com.me.modernJavainAction.chapter3.Color;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelTest {


  public static void main(String[] args) throws InterruptedException {
    List<Integer> inventory = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      inventory.add(i);
    }

    int threadCount = 100;
    ExecutorService executorService = Executors.newFixedThreadPool(32);
    // ExecutorService 는 비동기로 실행하는 작업을 단순화하여 사용할 수 있게 도와주는 자바 API

    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      executorService.submit(() -> {
        try {
          inventory.parallelStream().filter(x -> x % 2 == 0).forEach(System.out::println);
          System.out.println("-----------------------------");
          inventory.parallelStream().filter(x -> x % 2 == 1).forEach(System.out::println);
        } finally {
          latch.countDown();
        }
      });
    }
    latch.await();


  }
}
