package com.me.modernJavainAction.chapter3.sort;

import java.util.Comparator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentComparator implements Comparator<StudentComparator> {
  //Student 객체와 또 다른 Student 객체를 비교하고 싶으므로, <> 사이에 들어갈 타입 또한 Student
  int age; //나이
  int classNumber; //학급

  public StudentComparator(int age, int classNumber) {
    this.age = age;
    this.classNumber = classNumber;
  }


  @Override
  public int compare(StudentComparator o1, StudentComparator o2) {
//    if (o1.classNumber > o2.classNumber) {
//      return 1;
//    }
//    else if (o1.classNumber == o2.classNumber) {
//      return 0;
//    }
//    else {
//      return -1;
//    }
    /**
     * 만약 o1의 classNumber 가 o2의 classNumber 보다 크다면 양수가 반환 될 것이고,
     * 같다면 0을, 작다면 음수를 반환할 것이다.
     */
    return o1.classNumber - o2.classNumber;
  }

  public static void main(String[] args) {
    StudentComparator a = new StudentComparator(17 ,2);
    StudentComparator b = new StudentComparator(18 ,1);
    StudentComparator c = new StudentComparator(15 ,3);

    int isBig = a.compare(b, c);// a객체 와는 상관 없이 b와 c 객체를 비교한다.
    if (isBig > 0) {
      System.out.println("b객체가 c객체보다 큽니다.");
    }
    else if (isBig == 0) {
      System.out.println("두 객체의 크기가 같습니다.");
    }
    else {
      System.out.println("b객체가 c객체보다 작습니다.");
    }
  }
}
