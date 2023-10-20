package com.example.part1.chapter3;

// 전체 표현식을 함수형 인터페이스의 인스턴스로 취급
public class RunApp {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("run 1");

        Runnable r2 = new Runnable() {
            public void run() {
                System.out.println("run 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("run 1"));
    }

    private static void process(Runnable r){
        r.run();
    }
}
