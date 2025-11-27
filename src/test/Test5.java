package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("abc", "jb", "mbcd");


        Map<Character, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(data -> data.charAt(0)));

        System.out.println(collect);

        String s = list.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println(s);
    }
}
