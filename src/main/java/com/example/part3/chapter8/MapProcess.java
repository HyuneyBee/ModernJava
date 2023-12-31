package com.example.part3.chapter8;

import java.util.*;

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

        // getOrDefault
        Map<String, String> favouriteMovies = new java.util.HashMap<>(Map.ofEntries(
            Map.entry("Raphael", "Start Wars"),
            Map.entry("Olivia", "James Bond")));

        // James Bond
        favouriteMovies.getOrDefault("Olivia", "Matrix");
        // Matrix
        favouriteMovies.getOrDefault("Thibaut", "Matrix");

        // computeIfAbsent : 제공된 키에 해당하는 값이 없으면(값이 없거나 널), 키를 이용해 새값을 계산하고 맵에 추가한다.
        // computeIfPresent : 제공된 키가 존재하면 새 값을 계싼하고 맵에 추가한다.
        // compute : 제공된 키로 새 값을 계산하고 맵에 저장한다.

        Map<String, List<String>> friendsToMovies = new java.util.HashMap<>(Map.ofEntries(
            Map.entry("Raphael", new ArrayList<>(List.of("Start wars"))),
            Map.entry("Olivia", new ArrayList<>(List.of("James bond")))));

        String friend = "Raphael";
        List<String> movies = friendsToMovies.get(friend);
        if(movies == null){
            movies = new ArrayList<>();
            friendsToMovies.put(friend, movies);
        }

        friendsToMovies.computeIfAbsent("Raphael", name -> new ArrayList<>()).add("Star Wars");

        //remove
        String key = "Raphael";
        String value = "Jack Reacher 2";
        if (favouriteMovies.containsKey(key) &&
            Objects.equals(favouriteMovies.get(key), value)){
            favouriteMovies.remove(key);
        }

        favouriteMovies.remove(key, value);

        // replace
        Map<String, String> favouriteMovies2 = new HashMap<>();
        favouriteMovies2.put("Raphael", "Start wars");
        favouriteMovies2.put("Olivia", "James bond");

        favouriteMovies2.replaceAll((f, m) -> m.toUpperCase());


        // merge

        // 키의 중복이 없을 때
        Map<String, String> family = Map.ofEntries(Map.entry("Teo", "Star Wars"),
            Map.entry("Cristina", "James Bond"));

        Map<String, String> friends = Map.ofEntries(Map.entry("Raphael", "Star Wars"));
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);


        // 키의 중복이 있을 때
        Map<String, String> family2 = Map.ofEntries(Map.entry("Teo", "Star Wars"),
            Map.entry("Cristina", "James Bond"));

        Map<String, String> friends2 = Map.ofEntries(Map.entry("Raphael", "Star Wars"),
            Map.entry("Cristina", "Matrix"));

        HashMap<String, String> everyone2 = new HashMap<>(family2);

        friends2.forEach((k, v) ->
            everyone2.merge(k, v, (m1, m2) -> m1 + " & " + m2));

        // 영화를 몇 회 시청 했는지 기록

        HashMap<String, Long> moviesToCount = new HashMap<>();
        String movieName = "JamesBond";

        moviesToCount.merge(movieName, 1L, (k, c) -> c + 1L);

    }
}
