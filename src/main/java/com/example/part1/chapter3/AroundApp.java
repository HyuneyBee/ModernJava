package com.example.part1.chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AroundApp {
    public static void main(String[] args) throws IOException {
        String result = processFile();
        String oneLine = funcProcessFile((BufferedReader br) -> br.readLine());
        String twoLine = funcProcessFile((BufferedReader br) -> br.readLine() + br.readLine());

    }

    public static String processFile() throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return br.readLine();
        }
    }

    public static String funcProcessFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
}
