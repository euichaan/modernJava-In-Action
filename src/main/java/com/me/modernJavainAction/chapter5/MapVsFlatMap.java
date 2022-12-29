package com.me.modernJavainAction.chapter5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * map : 단일 스트림 안의 요소를 원하는 특정 형태로 변환할 수 있습니다.
 * flatmap : 메서드는 스트림의 형태가 배열과 같을 때, 모든 원소를 단일 원소 스트림으로 반환할 수 있습니다.
 */

@AllArgsConstructor
@Getter @Setter
class Person {
  private String name;
  private Integer age;
}

public class MapVsFlatMap {
  public static void main(String[] args) {
    List<Person> personList = Arrays.asList(new Person("chan", 26),
        new Person("taejun", 29));

    //Stream<Person> -> Stream<String>
    Set<String> names = personList.stream()
        .map(Person::getName)
        .collect(Collectors.toSet());
    names.forEach(System.out::println);

    //초기 형태
    personList.stream()
        .map(new Function<Person, String>() {
          @Override
          public String apply(Person person) {
            return person.getName();
          } //Stream<String>
        }).collect(Collectors.toSet());

    //람다식 적용
    personList.stream()
        .map(person -> person.getName())
        .collect(Collectors.toSet());

    //메서드 참조 적용
    personList.stream()
        .map(Person::getName)
        .collect(Collectors.toSet());

    //스트림의 형태가 배열과 같을 때, 모든 원소를 단일 원소 스트림으로 반환할 수 있습니다.
    //문자열의 길이가 3보다 큰 문자열을 출력하는 코드
    String[][] namesArray = new String[][] {
        {"kim", "taeng"}, {"mad", "play"},
        {"kim", "mad"}, {"taeng", "play"}};
    Set<String> namesWithFlatMap = Arrays.stream(namesArray)
        .flatMap(Arrays::stream)
        .filter(name -> name.length() > 3) //단일 원소 스트림 반환. filter 메서드 바로 체이닝해서 사용 가능
        .collect(Collectors.toSet());
    namesWithFlatMap.forEach(System.out::println);

    //flatMap을 사용하지 않는 경우
    Arrays.stream(namesArray)
        .map(innerArray -> Arrays.stream(innerArray)
            .filter(name -> name.length() > 3)
            .collect(Collectors.toSet()))
        .collect(HashSet::new, Set::addAll, Set::addAll);

    /**
     * <R> R collect(Supplier<R> supplier,
     *               BiConsumer<R, ? super T> accumulator,
     *               BiConsumer<R, R> combiner);
     */
    //supplier 는 새로운 결과 컨테이너를 만듭니다. 예제에서는 HashSet
    //accumulator 는 결과에 추가 요소를 통합하기 위한 역할을 합니다.
    //combiner 는 계산 결과를 결합하는 역할을 담당합니다.

    HashSet<String> namesWithMap = Arrays.stream(namesArray)
        .map(innerArray -> Arrays.stream(innerArray)
            .filter(name -> name.length() > 3)
            .collect(Collectors.toSet()))
        .collect(Collector.of(HashSet::new, Set::addAll, (oldValue, newValue) -> oldValue));

    System.out.println("----------------------------이전 출력-----------------------------------");

    String[][] namesArray2 = new String[][] {
        {"kim", "taeng"}, {"mad", "play"}
    };
    //2차원 배열에서 특정 문자만 출력하는 코드

    //flatMap
    Arrays.stream(namesArray2)
        .flatMap(Arrays::stream)
        .filter(name -> name.equals("taeng"))
        .forEach(System.out::println);

    System.out.println("-----------------------------------------------------------------");

    //map
    Arrays.stream(namesArray)
        .map(Arrays::stream)
        .forEach(nameex -> nameex.filter(name -> name.equals("taeng"))
            .forEach(System.out::println));

    System.out.println("---------------------forEachTest----------------------------------");
    String[][] namesArray3 = new String[][]{
        {"kim", "taeng"}, {"mad", "play"}};
    //모든 요소 출력 : flatMap
    Arrays.stream(namesArray3)
        .flatMap(Arrays::stream)
        .forEach(System.out::println);

    //모든 요소 출력 : map
    Arrays.stream(namesArray)
        .map(Arrays::stream)
        .forEach(loop -> loop.forEach(System.out::println));

    //예제 상에서 map 은 스트림의 스트림을 반환하는 반면,
    //flatMap 은 스트림을 반환한다고 보면 됩니다.

  }
}
