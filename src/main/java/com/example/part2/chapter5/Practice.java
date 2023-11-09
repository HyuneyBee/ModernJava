package com.example.part2.chapter5;

import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오
        List<Transaction> t2011 = transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
        Set<String> cities = transactions.stream()
            .map(t -> t.getTrader().getCity())
            .collect(Collectors.toSet());

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
        List<Trader> traders = transactions.stream()
            .map(Transaction::getTrader)
            .filter(t -> t.getCity().equals("Cambridge"))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());

        // 4. 모든 거래자 이름을 알파벳순으로 정렬해서 반환하시오.
        String traderStr = transactions.stream()
            .map(t -> t.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.joining());

        // 5. 밀라노에 거래자가 있는가?
        boolean milan = transactions.stream()
            .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        transactions.stream()
            .filter(t -> t.getTrader().getCity().equals("Milan"))
            .map(Transaction::getValue)
            .forEach(System.out::println);

        // 7. 전체 트랙잭션 중 최댓값은 얼마인가?
        Optional<Integer> max = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max);

        // 8. 전체 트랙잭션 중 최소값은 얼마인가?
        Optional<Transaction> reduce = transactions.stream()
            .reduce((t1, t2) -> t1.getValue() < t2.getYear() ? t1 : t2);

    }
}
