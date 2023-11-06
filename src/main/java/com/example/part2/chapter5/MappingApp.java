package com.example.part2.chapter5;

import com.example.part2.chapter4.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class MappingApp {
    public static void main(String[] args) {
        List<Dish> menu = Dish.createMenuList();

        // 이름으로 변환
        List<String> dishNames = menu.stream().map(Dish::getName).collect(Collectors.toList());

        // 이름의 길이로 변환
        List<Integer> dishNameLengths = menu.stream()
            .map(Dish::getName)
            .map(String::length)
            .collect(Collectors.toList());
    }
}
