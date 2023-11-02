package com.example.part2.chapter5;

import com.example.part2.chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterApp {
    public static void main(String[] args) {
        List<Dish> menu = Dish.createMenuList();

        List<Dish> vegetarianMenu = menu.stream()
            .filter(Dish::isVegetarian)
            .collect(Collectors.toList());

        // distinct() 고유 요소 필터링

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
            .filter(i -> i% 2 == 0)
            .distinct()
            .forEach(System.out::println);
    }
}
