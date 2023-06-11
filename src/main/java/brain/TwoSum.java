package brain;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        twoSum(arr, 6);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> duplicationMap = new HashMap();

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                duplicationMap.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (target % nums[i] == 0) {
                Integer delta = duplicationMap.get(target - nums[i]);
                if (delta != null) {
                    return new int[]{i, delta};
                }
            }

            Integer delta = map.get(target - nums[i]);
            if (delta != null) {
                return new int[]{i, delta};
            }
        }

        return new int[] {0, 0};
    }
}
