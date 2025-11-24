package number;

import java.util.Arrays;
import java.util.OptionalDouble;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};  // 3 is missing
        int n = nums.length + 1;       // total numbers should be 6 : one element missing so we added that;

        int expected = n * (n+1) /2;


//        for (int i: nums){
//            expected-= i;
//        }

        int sum = Arrays.stream(nums).sum();
        System.out.println(expected - sum);

    }
}
