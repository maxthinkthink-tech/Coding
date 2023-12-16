package algorithm.basic;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public int singleNumberSet(int[] nums) {
//        nums to set ,and  multiple by 2, then minus nums;
//        List<Integer> c = Arrays.asList(nums);
//        Set<Integer> set = new HashSet<Integer>();
//        for (int i : set) {
//
//        }
        return 0;
    }
}
