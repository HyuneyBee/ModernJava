package com.example.part3.chapter8;

import java.util.Map;

public class MapProcess {
    public static void main(String[] args) {
        Map<String, Integer> ageOfFriendsEntry = Map.ofEntries(
            Map.entry("Raphael", 30),
            Map.entry("Olivia", 25),
            Map.entry("Thibaut", 27));

        for(Map.Entry<String, Integer> entry : ageOfFriendsEntry.entrySet()){
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + " years old");
        }

        // forEach 메서드
        ageOfFriendsEntry.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old"));


        // 정렬
        ageOfFriendsEntry.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .forEachOrdered(System.out::println);

    }
}
