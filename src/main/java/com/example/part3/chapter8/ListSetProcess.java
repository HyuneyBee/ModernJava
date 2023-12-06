package com.example.part3.chapter8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListSetProcess {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("t1", "t2", "o1", "o2"));

        for(Iterator<String> iterator = strings.iterator(); iterator.hasNext();){
            String s = iterator.next();
            if(s.startsWith("t")){
                iterator.remove();
            }
        }

        // removeIf 사용
        strings.removeIf(s -> s.startsWith("t"));


        for(ListIterator<String> iterator = strings.listIterator(); iterator.hasNext();){
            String s = iterator.next();
            iterator.set(Character.toUpperCase(s.charAt(0)) + s.substring(1));
        }

        strings.replaceAll(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1));




    }


}
