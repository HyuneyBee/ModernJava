package com.example.part2.chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern", "Java", "In ", "Action");

        Stream<Object> empty = Stream.empty();

        // null 을 가지는 stream
        String home = System.getProperty("Home");
        Stream<String> value = home == null ? Stream.empty() : Stream.of("value");

        // ofNullable 사용
        Stream<String> home1 = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values = Stream.of("config", "home", "user")
            .flatMap(key -> Stream.ofNullable(System.getProperty(key)));

        //  배열 스트림
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        // 파일로 스트림 만들기
        long uniqueWords = 0;

        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        } catch (IOException e){
            System.out.println("Error");
        }

        // 무한 스트림 iterate 스트림을 무한으로 생성하지만 limit 사용하여 크기 명시, forEach 스트림 소비해서 출력
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        // iterate 범위 제한(두 번째 인수로 제한한다)
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
            .forEach(System.out::println);

        // takeWhile 사용 가능
        IntStream.iterate(0, n -> n + 4)
            .takeWhile(n -> n < 100)
            .forEach(System.out::println);





    }
}
