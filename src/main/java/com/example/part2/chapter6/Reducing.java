package com.example.part2.chapter6;

import com.example.part2.chapter4.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class Reducing {
    public static void main(String[] args) {
        // count
        List<Dish> menu = Dish.createMenuList();

        long count = menu.stream().count();

        // max
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> collect1 = menu.stream().collect(maxBy(dishComparator));
        Optional<Dish> collect2 = menu.stream().max(dishComparator);

        // sum
        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        // avg
        Double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

        // 여러가지 연산
        IntSummaryStatistics statistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        // 문자열 연결
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());

        // 요리 이름 중 콤마 추가
        String collect = menu.stream().map(Dish::getName).collect(joining(", "));

        // 리듀싱 요약 연산 가능
        // 리듀싱은 세 가지 인자를 받음
        // 첫 번째 인수는 리듀싱의 연산의 시작값 또는 스트림에 인수가 없을 때 반환값
        // 두 번째 인수는 6.2.2절에서 요리를 칼로리 정수로 변환할 때 사용한 변환 함수
        // 세 번째 인수는 두 종류의 ㅏㅇ목을 하나의 값으로 더하는 BinaryOperator
        Integer totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));

        // 한 개의 인수를 사용하여 가장 높은 칼로리 음식 찾기 가능
        Optional<Dish> mostCalorieDish = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));



    }
}
