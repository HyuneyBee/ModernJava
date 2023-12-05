package com.example.part3.chapter8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactory {
    public static void main(String[] args) {
        List<String> friends = Arrays.asList("Raphael", "Olivia");
        friends.set(0, "richard");
        // 고정된 크기로 선언이여서 요소 추가는 에러 발생
        friends.add("Thibaut");

        // 리스트 팩토리
        List<String> friends2 = List.of("Raphael", "Olivia", "Thibaut");
        // 고정된 크기로 선언하여 요소 추가 에러 발생
        // 데이터 변환이 필요 없을때 사용 용이
        friends2.add("Chih-Chum");

        // 집합 팩토리
        Set<String> friendsSet = Set.of("Raphael", "Olivia", "Thibaut");

        // 중복요소는 에러 발생
        //Set<String> friendsSet = Set.of("Raphael", "Olivia", "Olivia");

        // Map 팩토리
        // 열 개 이하의 쌍의 맵의 구성에 적절
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 27);

        // 많은 맵을 만들어야 할때 적절
        Map<String, Integer> ageOfFriendsEntry = Map.ofEntries(
            Map.entry("Raphael", 30),
            Map.entry("Olivia", 25),
            Map.entry("Thibaut", 27));
    }
}
