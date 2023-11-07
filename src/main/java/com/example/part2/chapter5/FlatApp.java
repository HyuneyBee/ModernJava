package com.example.part2.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatApp {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");

        // [["H", "e", "l", "l", "o"], ["W", "o", "r", "l", "d"]]
        List<String[]> collect = words.stream()
            .map(word -> word.split(""))
            .distinct()
            .collect(Collectors.toList());

        // ["H", "e", "l", "W", "o", "r", "d"]
        List<String> collect1 = words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());

        // 두 개의 숫자 리스트가 있으 떄 모든 숫자 쌍의 리스트를 반환하시오, 예를 들어
        // 두 개의 리스트 [1, 2, 3]과 [3, 4]가 주어지면 [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
        // 를 반환해야 한다.

        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        List<int[]> collect2 = number1.stream()
            .flatMap(i -> number2.stream().map(j -> new int[]{i, j}))
            .collect(Collectors.toList());

        System.out.println(1);

    }
}
