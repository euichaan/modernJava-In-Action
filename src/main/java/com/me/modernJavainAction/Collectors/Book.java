package com.me.modernJavainAction.Collectors;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Book {
  private String name;
  private int releaseYear;
  private String isbn;

  @Override
  public String toString() {
    return "Book{" +
        "name='" + name + '\'' +
        ", releaseYear=" + releaseYear +
        ", isbn='" + isbn + '\'' +
        '}';
  }


}
