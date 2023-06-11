package datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] r = twoSum(new int[]{3,2,4}, 6);
        for (int x : r) {
            System.out.println("x = " + x);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            // 必须放下后面，否则当 target =  nums[i] + nums[i]时，会返回 {i, i}
            map.put(nums[i], i);
        }
        return new int[] {0, 0};
    }
}
