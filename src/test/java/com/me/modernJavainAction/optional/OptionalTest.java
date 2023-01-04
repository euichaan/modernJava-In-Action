package com.me.modernJavainAction.optional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.NoSuchMessageException;


public class OptionalTest {

  /**
   * of는 null 받지 않음. null 이 아님이 확실할 때만 사용. 그렇지 않으면 NPE 터짐
   * ofNullable 는 null 값을 허용. null 이 아님이 확실하면 of를 사용
   */
  @Test
  public void givenNonNull_whenCreatesNonNullable() throws Exception {
    String name = "Chan";
    Optional<String> opt = Optional.of(name);
    assertEquals("Optional[Chan]", opt.toString());
  }

  @Test
  public void givenNull_whenThrowsErrorOnCreate() throws Exception {
    String name = null;
    assertThrows(NullPointerException.class, () -> {
      Optional<String> opt = Optional.of(name);
    }); //assertThrows 에 필요한 클래스를 등록하고, 람다식으로 예외를 던질 실행문을 작성
  }
  
  @Test
  public void givenNonNull_whenCreatesNullable() throws Exception {
    String name = "Chan";
    Optional<String> opt = Optional.ofNullable(name);
    assertEquals("Optional[Chan]", opt.toString());
  }
  
  @Test
  public void givenNull_whenCreatesNullable() throws Exception {
    String name = null;
    Optional<String> opt = Optional.ofNullable(name);
    assertEquals("Optional.empty", opt.toString());
  }

  @Test
  public void givenOptional_whenIsPresentWorks() throws Exception {
    Optional<String> opt = Optional.of("Chan");
    assertTrue(opt.isPresent());

    opt = Optional.ofNullable(null);
    assertFalse(opt.isPresent());
  }

  @Test
  public void givenOptional_whenIfPresentWorks() throws Exception {
    Optional<String> opt = Optional.of("Chan");
    opt.ifPresent(name -> System.out.println(name.length())); //Consumer
  }

  @Test
  public void whenOrElseWorks() throws Exception {
    String nullName = null;
    String name = Optional.ofNullable(nullName).orElse("Chan");
    assertEquals("Chan", name);
  }

  @Test
  public void orElseThrowEx() throws Exception {
    String nullName = null;
    assertThrows(IllegalArgumentException.class, () -> {
      String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
    });
  }
  
  @Test
  public void givenOptionalWithNull_whenGetThrowsException() throws Exception {
    Optional<String> opt = Optional.ofNullable(null);
    assertThrows(NoSuchElementException.class, () -> {
      String name = opt.get();
    });
  }

  @Test
  public void givenOptional_whenMapWorks() throws Exception {
    List<String> companyNames = Arrays.asList("Samsung", "SK", "NAVER", "Daum");
    Optional<List<String>> listOptional = Optional.of(companyNames);

    int size = listOptional.map(List::size).orElse(0);
    assertEquals(4, size);
  }
  
  @Test
  public void givenOptional_whenMapWorks2() throws Exception {
    String name = "Chan";
    Optional<String> nameOptional = Optional.ofNullable(name);
    int len = nameOptional.map(String::length).orElse(0);
    assertEquals(4, len);
  }

  @Test
  public void givenOptional_whenMapWorksWithFilter() throws Exception {
    String password = " password ";
    Optional<String> passOpt = Optional.of(password);
    boolean correctPassword = passOpt.filter(
        pass -> pass.equals("password")).isPresent();
    assertFalse(correctPassword);

    correctPassword = passOpt
        .map(String::trim)
        .filter(pass -> pass.equals("password"))
        .isPresent();

    assertTrue(correctPassword);
  }

}
