package number;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSimpleIndex {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 17;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            int rem = target - nums[i];

            if(map.containsKey(rem)){

                System.out.println("Index are - " + map.get(rem) + " " + i);
                return;

            }

            map.put(nums[i], i);

        }

    }
}
