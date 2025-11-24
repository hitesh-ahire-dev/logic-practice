package String;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

    public static Character getFirstNonRepeatedCharacter(String str) {
        //type-3: without using java8 stream
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        for (Character c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {


        String str = "hitesh";

        //type-1
        Character result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(result);

        //type-2
        Character result2 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()),
                        map -> map.entrySet()
                                .stream()
                                .filter(e -> e.getValue() == 1)
                                .map(Map.Entry::getKey)
                                .findFirst()
                                .orElse(null)
                ));
        System.out.println(result2);

        System.out.println(getFirstNonRepeatedCharacter(str));
    }
}