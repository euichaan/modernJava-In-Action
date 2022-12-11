package com.me.modernJavainAction.chapter1;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmployTest {

  public static void main(String[] args) {

    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee(26, "chan", "Hwang"));
    employeeList.add(new Employee(28, "sungMin", "Ryu"));

//
//        Arrays.asList(new Employee(26, "chan", "Hwang")
//        , new Employee(28, "seoungMin", "Ryu"));


//    employeeList.stream()
//        .filter(e -> e.age > 26)
//        .collect(toList());
////        .forEach(System.out::println);
//    try {
//      employeeList.add(new Employee(30, "a", "b"));
//    } catch (UnsupportedOperationException e) {
//      e.printStackTrace();
//    }

    List<Employee> unmodifiableEmployList = List.copyOf(employeeList); // 방어적 복사
    List<Employee> unmodifiableEmployList2 = new ArrayList<>(employeeList); // 방어적 복사

    employeeList.add(new Employee(30, "b", "b"));
    for (Employee employee : unmodifiableEmployList) {
      System.out.println("employee = " + employee);
    }
    System.out.println("-------------------------------");

    for (Employee employee : unmodifiableEmployList2) {
      System.out.println("employee = " + employee);
    }



  }

}
