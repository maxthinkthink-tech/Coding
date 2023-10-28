package algorithm.array;

import java.util.Arrays;

public class SkipGame {
    public static void main(String[] args) {
        int res = jump(new int[]{2,1,1,1,1});
        System.out.println(res);
    }
    public static int jump(int[] nums) {
        int cnt = 0;
        if (nums.length == 1) {
            return cnt;
        }

        for (int i = 0; i < nums.length;) {
            int s = nums[i];
            cnt++;
            if (i+s >= nums.length-1) {
                return cnt;
            }

            int m = nums[i];
            int j = 1;
            int k = i;
            for (; j <= s; j++) {
                if (m <= nums[i+j]+j) {
                    m = nums[i+j] +j;
                    k = i+j;
                }
                // m = Math.max(m, nums[i+j] + j);
            }
            i = k;
        }

        return cnt++;
    }
}
