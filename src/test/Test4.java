package test;

import java.util.*;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banna", 4);
        map.put("Berry", 2);
        map.put("Orange", 7);

        LinkedHashMap<String, Integer> collect = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println(collect);

    }
}
