package com.me.modernJavainAction.chapter6;

import static com.me.modernJavainAction.chapter6.dish.Dish.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.me.modernJavainAction.chapter6.dish.Dish;
import com.me.modernJavainAction.chapter6.dish.Type;

public class Grouping {
	enum CaloricLevel {DIET, NORMAL, FAT};

	public static void main(String[] args) {
		// 1. 메뉴를 그룹화
		Map<Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println("Dishes grouped By Type: " + dishesByType);

		// 2. 좀 더 복잡한 분류 기준으로 그룹화
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
			groupingBy(dish -> {
				if (dish.getCalories() <= 400) return CaloricLevel.DIET;
				else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
				else return CaloricLevel.FAT;
			}));

		// 3. 그룹화된 요소 조작 : 500칼로가 넘는 요리 필터링. 그룹화 전 필터 적용?
		Map<Type, List<Dish>> caloricDishesByTypeWrong = menu.stream().filter(dish -> dish.getCalories() > 500)
			.collect(groupingBy(Dish::getType));

		// 3. 그룹화된 요소 조작 옳은 방법
		Map<Type, List<Dish>> caloricDishesByTypeRight = menu.stream()
			.collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));

		System.out.println(caloricDishesByTypeWrong);
		System.out.println(caloricDishesByTypeRight);

		// 4. 매핑 이용한 요소 변환
		Map<Type, List<String>> dishNamesByType = menu.stream()
			.collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
		System.out.println(dishNamesByType);

		Map<Type, Set<String>> dishNamesByTag = menu.stream()
			.collect(groupingBy(Dish::getType,
				flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
		System.out.println(dishNamesByTag);

		// 5. 다수준 그룹화
		Map<Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
			groupingBy(Dish::getType, // 첫 번째 수준의 분류 함수
				groupingBy(dish -> { // 두 번째 수준의 분류 함수
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}))
		);
		System.out.println(dishesByTypeCaloricLevel);

		// 6. 서브그룹으로 데이터 수집
		Map<Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(typesCount);

		Map<Type, Optional<Dish>> mostCaloricByType = menu.stream()
			.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

		// 7. 컬렉터 결과를 다른 형식에 적용하기
		Map<Type, Dish> mstCaloricByType = menu.stream()
			.collect(groupingBy(Dish::getType,
				collectingAndThen(
					maxBy(comparingInt(Dish::getCalories)), //적용할 컬렉터
					Optional::get))); //반환 함수
		Map<Type, Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType,
			summingInt(Dish::getCalories)));

		Map<Type, HashSet<CaloricLevel>> caloricLevelsByType = menu.stream().collect(
			groupingBy(Dish::getType, mapping(dish -> {
				if (dish.getCalories() <= 400)
					return CaloricLevel.DIET;
				else if (dish.getCalories() <= 700)
					return CaloricLevel.NORMAL;
				else
					return CaloricLevel.FAT;
			}, toCollection(HashSet::new))));
	}
}
