package com.me.modernJavainAction.chapter3.sort;

import java.util.Comparator;

public class AnonymousTest {

  public static void main(String[] args) {
    Student a = new Student(17, 2);  // 17살 2반
    Student b = new Student(18, 1);  // 18살 1반
    Student c = new Student(15, 3);  // 15살 3반

    int isBig = comp.compare(b, c);
    if(isBig > 0) {
      System.out.println("b객체가 c객체보다 큽니다.");
    }
    else if(isBig == 0) {
      System.out.println("두 객체의 크기가 같습니다.");
    }
    else {
      System.out.println("b객체가 c객체보다 작습니다.");
    }

  }
  //지역변수 처럼 정적으로 선언
  public static Comparator<Student> comp = new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
      return o1.classNumber - o2.classNumber;
    }
  };
  public static Comparator<Student> compAge = new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
      return o1.age - o2.age;
    }
  };
}
class Student {
  int age;
  int classNumber;

  public Student(int age, int classNumber) {
    this.age = age;
    this.classNumber = classNumber;
  }
}
