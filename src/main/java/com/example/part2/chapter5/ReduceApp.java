package com.example.part2.chapter5;

import com.example.part2.chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceApp {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // 기존
        int sum = 0;
        for (int x : integers){
            sum += x;
        }

        // 람다 식 reduce는 초깃값, BinaryOperator<T> 사용
        int sum2 = integers.stream().reduce(0, (a, b) -> a + b);

        int product = integers.stream().reduce(1, (a, b) -> a * b);

        int sum3 = integers.stream().reduce(0, Integer::sum);

        // 초기값 없으면 Optional
        Optional<Integer> sum4 = integers.stream().reduce((a, b) -> (a + b));

        // 최대값
        Optional<Integer> max = integers.stream().reduce(Integer::max);

        // 최소값
        Optional<Integer> min = integers.stream().reduce(Integer::min);

        // map과 reduce 메서드를 이용해서 스트림의 요리 개수를 계산하시오
        List<Dish> menu = Dish.createMenuList();

        int totalCount = menu.stream().map(d -> 1).reduce(0, Integer::sum);
        long count = menu.stream().count();

    }
}
