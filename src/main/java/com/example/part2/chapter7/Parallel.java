package com.example.part2.chapter7;

import java.util.stream.LongStream;
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

    // 올바른 자료구조를 선택하여야 병렬 실행도 최적의 성능을 발휘
    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1, n)
            .parallel()
            .reduce(0L, Long::sum);
    }
}
