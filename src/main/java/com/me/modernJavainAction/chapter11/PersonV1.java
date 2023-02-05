package com.me.modernJavainAction.chapter11;

import java.util.Optional;

public class PersonV1 {
	private Car car;

	public Optional<Car> getCarAsOptional() {
		return Optional.ofNullable(car);
	}
}
