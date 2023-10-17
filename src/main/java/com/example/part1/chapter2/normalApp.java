package com.example.part1.chapter2;

import java.util.ArrayList;
import java.util.List;

public class normalApp {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.generateApples(10);

        List<Apple> greenApples = filterGreenApple(inventory);
        List<Apple> redApples = filterAppleByColor(inventory, Color.RED);

        List<Apple> flagGreenApples = filterApples(inventory, Color.GREEN, null, true);
        List<Apple> flagWeightApples = filterApples(inventory, null, 150, false);

    }

    // 초록색 사과만 필터
    private static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 파라미터로 받은 색의 사과만 필터
    private static List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    // 만약 무게와 색을 상황에 따라 필터하는 함수라면? 엉망진창
    private static List<Apple> filterApples(List<Apple> inventory, Color color, Integer weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && color.equals(apple.getColor())) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }
}
