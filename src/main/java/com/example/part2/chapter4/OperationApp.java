package com.example.part2.chapter4;

import java.util.List;

import static java.awt.SystemColor.menu;

// 4.4.1
public class OperationApp {
    public static void main(String[] args) {
        List<Dish> menu = Dish.createMenuList();
        // 중간 연산은 최종 연산 전 까지 아무 연산도 수행하지 않는 것 lazy 하다.

        // 마지막 연산자 count 최종 연산, filter, distinct, limit 중간 연산
        long count = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .distinct()
            .limit(3)
            .count();
    }
}
