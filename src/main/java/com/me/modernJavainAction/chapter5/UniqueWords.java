package com.me.modernJavainAction.chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UniqueWords {

  //Files.lines() 는 주어진 파일의 행 스트림을 문자열로 반환합니다.
  public static void main(String[] args) {
    long uniqueWords = 0;
    try {
      uniqueWords = Files.lines(Paths.get("..."), Charset.defaultCharset())
          .flatMap(line -> Arrays.stream(line.split("")))
          .distinct()
          .count();
      System.out.println("There are " + uniqueWords + " unique words in data.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  } //Main END

}
