package com.me.modernJavainAction.chapter1;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferenceSortTest {

  public static void main(String[] args) {
    List<Employee> emp = new ArrayList<Employee>();
    emp.add(new Employee(25, "Raja", "Ramesh"));
    emp.add(new Employee(30, "Sai", "Adithya"));
    emp.add(new Employee(28, "Jai", "Dev"));
    emp.add(new Employee(23, "Ravi", "Chandra"));
    emp.add(new Employee(35, "Chaitanya", "Krishna"));


    emp.stream()
        .sorted(comparing(Employee::getFirstName) //비교할 값을 결정하는 Function 을 파라미터로 받아 Comparator 생성
            .thenComparing(Employee::getLastName))
        .forEach(System.out::println);

    System.out.println("------------------------------------------");

    List<Apple> inventory = Arrays.asList(
        new Apple(80, "green"),
        new Apple(155, "green"),
        new Apple(80, "red"),
        new Apple(120, "red")
    );

    //Apple::getWeight 는 Function<Apple, Object> 입니다.
    inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor)); //무게 오름차순 정렬. 무게가 같으면 색 오름차순 정렬

    inventory.stream()//Collection 의 stream.Collection 은 interface
        .sorted(comparing(Apple::getWeight) //무게로 1차 정렬
            .thenComparing(Apple::getColor).reversed()) //이름 내림차순으로 2차 정렬
        .forEach(System.out::println);

  }
}
