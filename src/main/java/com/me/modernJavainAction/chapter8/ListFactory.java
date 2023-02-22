package com.me.modernJavainAction.chapter8;

import java.util.List;
import java.util.Set;

public class ListFactory {
	public static void main(String[] args) {
		Car car1 = new Car("chan", 0); // name, position
		Car car2 = new Car("dong", 0);
		List<Car> cars = List.of(car1, car2);
		car2.setPosition(2);
		System.out.println(cars);
	}
}
