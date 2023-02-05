package com.me.modernJavainAction.chapter11;

import java.util.Optional;

public class OptionalMain {

	public static void main(String[] args) {
		extractInsuranceName();
	}

	private static void extractInsuranceName() {
		Insurance insurance = new Insurance();
		Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
		Optional<String> name = optInsurance.map(Insurance::getName);
		System.out.println(name);
	}

	// public String getCarInsuranceName(Person person) {
	// 	Optional<Person> optPerson = Optional.of(person);
	// 	Optional<String> name = optPerson.map(Person::getCar)
	// 		.map(Car::getInsurance)
	// 		.map(Insurance::getName);
	// 	return name.orElse("UnKnown");
	// }

	public String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
			.flatMap(Car::getInsurance)
			.map(Insurance::getName)
			.orElse("UnKnown");
	}


}
