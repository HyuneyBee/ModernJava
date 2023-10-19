package com.example.part1.chapter2;

import java.util.ArrayList;
import java.util.List;

public class predicateApp {
    public static void main(String[] args) {
        List<Apple> inventory = Apple.generateApples(10);

        List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());

        // 익명클래스
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        // 람다 표현식
        List<Apple> heavyApples = filterApples(inventory, apple -> apple.getWeight() > 150);

        List<Apple> abstractListRedApples = filter(inventory, apple -> Color.RED.equals(apple.getColor()));
    }

    // 함수형 인터페이스 활용한 필터 방법
    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 리스트 형식의 추상화
    private static <T> List<T> filter(List<T> list, Predicate<T> t){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(t.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}
