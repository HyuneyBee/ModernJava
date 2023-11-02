package com.example.part2.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ForApp {
    public static void main(String[] args) {
        List<Dish> menu = Dish.createMenuList();
        // 외부 반복
        List<String> highCaloricDishes = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()){
            Dish dish = iterator.next();
            if(dish.getCalories() > 300){
                highCaloricDishes.add(dish.getName());
            }
        }

        // 내부 반복
        List<String> highCaloricMenu = menu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .map(Dish::getName)
            .collect(Collectors.toList());

    }
}
