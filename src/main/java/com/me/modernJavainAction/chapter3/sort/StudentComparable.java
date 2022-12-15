package com.me.modernJavainAction.chapter3.sort;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentComparable implements Comparable<StudentComparable> {
  //Student 객체와 또 다른 Student 객체를 비교하고 싶으므로, <> 사이에 들어갈 타입 또한 Student
  int age; //나이
  int classNumber; //학급

  public StudentComparable(int age, int classNumber) {
    this.age = age;
    this.classNumber = classNumber;
  }

  @Override
  public int compareTo(StudentComparable o) {
    /**
     * 비교 구현
     * 자기 자신과 매개변수 비교. 자기 자신을 기준으로 상대방과의 차이 값을 비교하여 반환
     */
    // 자기 자신의 age가 o의 age보다 크다면 양수
//    if (this.age > o.age) {
//      return 1;
//    }
//    // 같다면 0
//    else if (this.age == o.age) {
//      return 0;
//    }
//    // 자기 자신의 age가 o의 age보다 작다면 음수
//    else {
//      return -1;
//    }
    /**
     * 만약 자신의 age가 o의 age보다 크다면 양수가 반환 될 것,
     * 같다면 0을, 작다면 음수를 반환할 것이다.
     */
    return this.age - o.age;
  }

  public static void main(String[] args) {
    StudentComparable a = new StudentComparable(17, 2); // 17살 2반
    StudentComparable b = new StudentComparable(18, 1); // 18살 1반

    int isBig = a.compareTo(b);

    if (isBig > 0) {
      System.out.println("a객체가 b객체보다 큽니다");
    }
    else if (isBig == 0) {
      System.out.println("두 객체의 크기가 같습니다.");
    }
    else {
      System.out.println("a객체가 b객체보다 작습니다.");
    }

    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    System.out.println(min - 1); //2147483647 underflow
    System.out.println(max + 1); //-2147483648 overflow

  }
}
