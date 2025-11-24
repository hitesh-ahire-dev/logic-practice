package String;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindOutFirstDublicateCharator {
    public static void main(String[] args) {
        String str = "abcdandt";

        Map.Entry<String, Long> stringLongEntry = str.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(data -> data.getValue() > 1)
                .findFirst()
                .orElse(null);


        Optional<Map.Entry<String, Long>> collect = str
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()),
                        map -> map.entrySet().stream().filter(e -> e.getValue() > 1).findFirst()
                ));
        Optional<Map.Entry<String, Long>> firstDuplicate = collect;

        System.out.println(collect);
    }

}
