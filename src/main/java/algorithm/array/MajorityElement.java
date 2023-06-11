package algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = {3,2,3};
        int r = majorityElement(a);
        System.out.println(r);
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> r = new HashMap<>();
        int m = 0;
        int mk = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (r.containsKey(k)) {
                r.put(k, r.get(k) + 1);
            } else {
                r.put(k, 1);
            }
            if (m < r.get(k)) {
                m = r.get(k);
                mk = k;
            }
        }
        return mk;
    }
}
