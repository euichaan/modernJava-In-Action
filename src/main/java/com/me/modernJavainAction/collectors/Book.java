package com.me.modernJavainAction.collectors;

import java.util.Optional;

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
