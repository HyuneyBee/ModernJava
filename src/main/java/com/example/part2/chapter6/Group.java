package com.example.part2.chapter6;

import com.example.part2.chapter4.Dish;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Group {
    public static void main(String[] args) {
        List<Dish> menu = Dish.createMenuList();

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));

        // 그룹화 하기 전 필터 적용
        // 특정 메뉴가 사질 수 있음
        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().filter(dish -> dish.getCalories() > 500)
            .collect(groupingBy(Dish::getType));

        // groupingBy 에서 필터 적용 하면 모든 Type에 대한 그룹 가능
        Map<Dish.Type, List<Dish>> caloricDishesByType2 = menu.stream()
            .collect(groupingBy(Dish::getType,
                filtering(dish -> dish.getCalories() > 500, toList())));

        // mapping 사용 가능
        Map<Dish.Type, List<String>> dishNamesByType = menu.stream()
            .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        // flatMap 변환
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", Arrays.asList("greasy", "salty"));
        dishTags.put("beef", Arrays.asList("salty", "roasted"));
        dishTags.put("chicken", Arrays.asList("fried", "crisp"));
        dishTags.put("french fries", Arrays.asList("greasy", "fried"));
        dishTags.put("rice", Arrays.asList("light", "natural"));
        dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
        dishTags.put("pizza", Arrays.asList("tasty", "salty"));
        dishTags.put("prawns", Arrays.asList("tasty", "roasted"));

        Map<Dish.Type, Set<String>> dishNamesByType2 = menu.stream()
            .collect(groupingBy(Dish::getType,
                flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));

        // 다수준 그룹화 타입에서 칼로리레벨로 다시 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
            groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }))
        );

        // 서브그룹으로 데이터 수집
        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));

        // 높은 칼로리 요리 데이터 수집
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
            .collect(groupingBy(Dish::getType,
                maxBy(Comparator.comparingInt(Dish::getCalories))));

        // 컬렉터 결과를 다른 형식에 적용하기
        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream()
            .collect(groupingBy(Dish::getType,
                collectingAndThen(
                    maxBy(Comparator.comparingInt(Dish::getCalories)),
                    Optional::get)));
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}
}
