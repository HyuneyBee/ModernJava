package com.example.part1.chapter2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Apple {
    private Color color;
    private Integer weight;

    public Apple(Color color, Integer weight){
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    public static List<Apple> generateApples(int numberOfApples) {
        return new Random().ints(numberOfApples, 0, Color.values().length)
            .mapToObj(randomColorIndex -> new Apple(Color.values()[randomColorIndex], generateRandomWeight()))

            .collect(Collectors.toList());
    }

    private static int generateRandomWeight() {
        return new Random().nextInt(201) + 100;
    }
}
