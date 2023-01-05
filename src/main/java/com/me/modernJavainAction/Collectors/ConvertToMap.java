package com.me.modernJavainAction.Collectors;

import java.util.List;
import java.util.Map;
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

}
