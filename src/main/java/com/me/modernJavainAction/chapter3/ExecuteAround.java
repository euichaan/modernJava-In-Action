package com.me.modernJavainAction.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 실행 어라운드 패턴 :
 * 실제 자원을 처리하는 코드를 설정과 정리 두 과정이 둘러싸는 형태를 갖는다.
 *
 * 람다를 함수형 인터페이스를 인수로 받는 메서드로 전달할 수 있다.
 * 함수형 인터페이스의 추상 메서드와 같은 시그니처를 가진다.
 */
public class ExecuteAround {

  public static void main(String[] args) throws IOException {
    String oneLine = processFile((BufferedReader br) -> br.readLine());
    //람다 표현식으로 함수형 인터페이스의 추상 메서드 구현을 직접 전달
    //전달된 코드는 함수형 인터페이스의 인스턴스로 전달된 코드와 같은 방식으로 처리
    String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine()); // (BufferedReader) -> String

  }

  //함수형 인터페이스를 인수로 받는 메서드
  public static String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {//한 행을 읽는 코드
      return p.process(br);
    }
  }

  @FunctionalInterface //실제로 함수형 인터페이스가 아니라면 컴파일러가 예외를 발생시킴
  public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException; // BufferedReader -> String
  }

}
