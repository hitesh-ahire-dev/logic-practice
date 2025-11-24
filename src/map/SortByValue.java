package map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banna", 4);
        map.put("Berry", 2);
        map.put("Orange", 7);

        map.
                entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1,e2) -> e2,
                        LinkedHashMap::new
                )).forEach((k, v) ->{
                    System.out.println(k + " -> " +v);
                });
    }
}
