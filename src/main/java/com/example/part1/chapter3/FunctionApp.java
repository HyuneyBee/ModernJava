package com.example.part1.chapter3;

import com.example.part1.chapter2.Apple;
import com.example.part1.chapter2.Color;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionApp {

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(Arrays.asList("String", "String2"), nonEmptyStringPredicate);

        // [7, 2, 6]
        List<Integer> I = map(Arrays.asList("lambdas", "in", "action"), String::length);

        // 3.6
        List<Apple> inventory = Apple.generateApples(10);
        // 람다로 정렬
        inventory.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
        // 메서드 참조 요약
        inventory.sort(Comparator.comparing(Apple::getWeight));

        //예제
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        //생성자 참조 가능
        BiFunction<Color, Integer, Apple> c1 = Apple::new;
        Apple a1 = c1.apply(Color.RED, 110);

        // 기존
        BiFunction<Color, Integer, Apple> c2 = (color, weight) -> new Apple(color, weight);
        Apple a2 = c2.apply(Color.RED, 110);

        // 3.7 람다, 메서드 참조 발전시키기
        //1
        inventory.sort(new AppleComparator());
        //2
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        //3
        inventory.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
        //4
        inventory.sort(Comparator.comparing(Apple::getWeight));

        // 3.8 람다 표현식을 조합할 수 있는 유용한 메서드

        // Comparator 연결
        inventory.sort(Comparator.comparing(Apple::getWeight)
            .reversed()
            .thenComparing(Apple::getColor));

        // Predicate 조합
        java.util.function.Predicate<Apple> redApple = apple -> apple.getColor().equals(Color.RED);

        java.util.function.Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight() > 150);

        // Function
        java.util.function.Function<Integer, Integer> f = x -> x + 1;
        java.util.function.Function<Integer, Integer> g = x -> x * 2;
        java.util.function.Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1); // 4반환

    }

    // Predicate boolean 반환
    @FunctionalInterface
    public interface Predicate<T>{
        boolean test(T t);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> t){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(t.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    // Consumer void 반환
    @FunctionalInterface
    public interface Consumer<T>{
        void accept(T t);
    }

    public <T> void forEach(List<T> list, Consumer<T> c) {
        for(T t: list){
            c.accept(t);
        }
    }

    // Functional 인자 T를 R로 변환한다.
    @FunctionalInterface
    public interface Function<T, R>{
        R apply(T t);
    }

    public static  <T, R> List<R> map(List<T> list, Function<T, R> f){
        List<R> result = new ArrayList<>();
        for(T t: list){
            result.add(f.apply(t));
        }
        return result;
    }

    public static class AppleComparator implements Comparator<Apple>{
        public int compare(Apple a1, Apple a2){
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
