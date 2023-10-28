package algorithm.array;

import java.util.Arrays;

class x {
    public static void main(String[] args) {
        int[] a = new int[]{2,-5,-2,-4,3};
        int r = maxProduct(a);
        System.out.println(r);
    }

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] dt = new int[len];
        dt[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int t = dt[i-1] * nums[i];
            if (t == 0 ) {
                dt[i] = nums[i];
            } else {
                dt[i] = t;
            }
        }

        String s;
        String ss = "";
//        String t = s.subString(indices[i] + ss.length(), indices[i+1]);


        int[] dp = new int[len];
        dp[len-1] = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            int t = dp[i+1] * nums[i];
            if (t == 0 ) {
                dp[i] = nums[i];
            } else {
                dp[i] = t;
            }
        }

        int max = dp[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(dp[i], max);
        }

        for (int i = 0; i < len; i++) {
            max = Math.max(dt[i], max);
        }


        return max;
    }
}