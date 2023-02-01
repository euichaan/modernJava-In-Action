package com.me.modernJavainAction.chapter8;

import java.util.stream.Stream;

public class Car {
	private String name;
	private int position = 0;

	public Car(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
