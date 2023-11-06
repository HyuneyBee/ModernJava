package com.example.part2.chapter5;

import com.example.part2.chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SliceApp {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
            new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH)
        );

        // 순차적으로 돌며 taskWhile 거짓된 상황이 나오면 멈춤
        List<Dish> collect = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320)
            .collect(Collectors.toList());

        // 순차적으로 돌며 dropWhile 거짓된 상황이 나오면 멈추지만 그 이외의 나머지를 슬라이스 함
        List<Dish> dropCollect = specialMenu.stream().dropWhile(dish -> dish.getCalories() < 320)
            .collect(Collectors.toList());

        // 스트림 축소
        List<Dish> dishes = specialMenu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .limit(3)
            .collect(Collectors.toList());

        // 요소 건너 뛰기
        List<Dish> skipDishes = specialMenu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .skip(2)
            .collect(Collectors.toList());

    }
}
