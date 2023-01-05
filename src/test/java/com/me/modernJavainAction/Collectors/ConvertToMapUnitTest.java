package com.me.modernJavainAction.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConvertToMapUnitTest {
  private List<Book> bookList = new ArrayList<>();
  private ConvertToMap convertToMap = new ConvertToMap();

  @BeforeEach
  void init() {
    bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
    bookList.add(new Book("The Two Towers", 1954, "0345339711"));
    bookList.add(new Book("The Return of the King", 1955, "0618129111"));
  }
  
  @Test
  public void whenConvertFromListToMap() throws Exception {
    assertTrue(convertToMap.listToMap(bookList).size() == 3);
  }

  @Test
  public void whenMapHasDuplicateKey_without_merge_function_then_runtime_exception() {
    assertThrows(IllegalStateException.class, () -> {
      convertToMap.listTOMapWithDupKeyError(bookList);
    });
  }

  @Test
  public void whenMapHasDuplicateKeyThenMergeFunctionHandlesCollision() {
    Map<Integer, Book> booksByYear = convertToMap.listToMapWithDupKey(bookList);
    assertEquals(2, booksByYear.size());
    assertEquals("0395489318", booksByYear.get(1954).getIsbn());
  }

}