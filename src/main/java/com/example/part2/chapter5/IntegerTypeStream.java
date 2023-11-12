package com.example.part2.chapter5;

import com.example.part2.chapter4.Dish;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerTypeStream {
    public static void main(String[] args) {
        List<Dish> menu = Dish.createMenuList();

        // 기본형으로 언박싱 함
        int calories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);

        // 숫자 스트림으로 매핑
        int sum = menu.stream()
            .mapToInt(Dish::getCalories).sum();

        // 객체 스트림으로 복원하기
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        // OptionalInt : 0이라는 기본값 때문에 잘못된 결과 도출 방지
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();

        // 숫자범위
        IntStream intStream1 = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
    }
}
