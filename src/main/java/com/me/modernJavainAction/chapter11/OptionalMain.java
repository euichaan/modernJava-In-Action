package com.me.modernJavainAction.chapter11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OptionalMain {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		Optional<Object> value = Optional.ofNullable(map.get("key"));
	}

	private static void extractInsuranceName() {
		Insurance insurance = new Insurance();
		Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
		Optional<String> name = optInsurance.map(Insurance::getName);
		System.out.println(name);
	}

	private String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
			.flatMap(Car::getInsurance)
			.map(Insurance::getName)
			.orElse("UnKnown");
	}

	private Set<String> getCarInsuranceNames(List<Person> persons) {
		return persons.stream()
			.map(Person::getCar)
			.map(optCar -> optCar.flatMap(Car::getInsurance))
			.map(optIns -> optIns.map(Insurance::getName))
			.flatMap(Optional::stream)
			.collect(Collectors.toSet());
	}

	private Insurance findCheapestInsurance(Person person, Car car) {
		Insurance cheapestCompany = new Insurance();
		// ...
		return cheapestCompany;
	}

	public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
		if (person.isPresent() && car.isPresent()) {
			return Optional.of(findCheapestInsurance(person.get(), car.get()));
		} else {
			return Optional.empty();
		}
	}

	public Optional<Insurance>nullSafeFindCheapestInsuranceQuiz(Optional<Person> person, Optional<Car> car) {
		// person.flatMap(Optional<Insurance>)
		return person.flatMap(p -> car.map(c -> findCheapestInsurance(p ,c)));
	}

	public void filteringWithOptional(Optional<Insurance> optInsurance) {
		optInsurance.filter(insurance ->
			"CambridgeInsurance".equals(insurance.getName()))
			.ifPresent(x -> System.out.println("ok"));
	}

	public String getCarInsuranceName(Optional<Person> person, int minAge) {
		return person.filter(p -> p.getAge() >= minAge)
			.flatMap(Person::getCar)
			.flatMap(Car::getInsurance)
			.map(Insurance::getName)
			.orElse("UnKnown");
	}

	public static Optional<Integer> stringToInt(String input) {
		try {
			return Optional.of(Integer.parseInt(input));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
}
