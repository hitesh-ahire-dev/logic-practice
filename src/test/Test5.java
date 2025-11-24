package test;

import java.util.Arrays;
import java.util.List;

public class Test5 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        double v = list.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0);

        System.out.println(v);
    }
}
