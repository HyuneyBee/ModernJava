package com.example.part1.chapter3;

import com.example.part1.chapter2.Predicate;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionApp {

    public static void main(String[] args) {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(Arrays.asList("String", "String2"), nonEmptyStringPredicate);


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
}
