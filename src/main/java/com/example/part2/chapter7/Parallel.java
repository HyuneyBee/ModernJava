package com.example.part2.chapter7;

import java.util.stream.Stream;

public class Parallel {
    public static void main(String[] args) {

    }

    private static long sequentialSum(long n){
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .reduce(0L, Long::sum);
    }
    private static long parallelSum(long n){
        return Stream.iterate(1L, i -> i + 1)
            .limit(n)
            .parallel()
            .reduce(0L, Long::sum);
    }
}
