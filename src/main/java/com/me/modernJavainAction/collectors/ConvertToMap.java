package com.me.modernJavainAction.collectors;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertToMap {
    public Map<String, String> listToMap(List<Book> books) {
      return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
    }

    public Map<Integer, Book> listTOMapWithDupKeyError(List<Book> books) {
      return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity()));
    }

    public Map<Integer, Book> listToMapWithDupKey(List<Book> books) {
      return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(), (existing, replacement) -> existing));
    }

    public Map<Integer, Book> listToConcurrentMap(List<Book> books) {
      return books.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
          (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    //TreeMap -> 키의 자연스러운 순서에 의해 정렬. 명시적으로 정렬할 필요 없음
    public TreeMap<String, Book> listToSortedMap(List<Book> books) {
      return books.stream()
          .collect(Collectors.toMap(Book::getName, Function.identity(), (o1, o2) -> o1, TreeMap::new));
    }

}
