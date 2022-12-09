package com.me.modernJavainAction.chapter1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Employee {
  int age;
  String firstName;
  String lastName;

  @Override
  public String toString() {
    return "Employee [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
  }

}
