package com.example.part2.chapter5;

import com.example.part2.chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchApp {
    public static void main(String[] args) {
        List<Dish> menu = Dish.createMenuList();

        // 모든 요소와 일치하는지 검사
        boolean isHealthy1 = menu.stream().allMatch(dish -> dish.getCalories() < 1000);

        //모든 요소와 일치하지 않는지 검사
        boolean isHealthy2 = menu.stream().allMatch(dish -> dish.getCalories() >= 1000);

        // anyMatch, allMatch, noneMatch 쇼트서킷 기법 즉 전체 스트림을 처리하지 않아도 결과를 반환

        // 채식 요소 검색
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();

        // 논리적인 아이템 순서가 정해저 있을때 유용
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = integers.stream()
                                                                    .map(i -> i * i)
                                                                    .filter(n -> n % 3 == 0)
                                                                    .findFirst();
    }
}
