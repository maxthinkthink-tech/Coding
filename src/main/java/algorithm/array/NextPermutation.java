package algorithm.array;

import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                // （i， n）范围内 比 i-1 大的最小值
                int pre = nums[i];
                int preI = i;
                for (int j = i; j <= nums.length -1; j++) {
                    if (nums[j] > nums[i-1] && nums[j] < pre) {
                        pre = nums[j];
                        preI = j;
                    }
                }
                int tmp = nums[preI];
                nums[preI] = nums[i-1];
                nums[i-1] = tmp;

                // i,n 范围内的数据 从小打大排序
                // i,n 已经是降序，直接变升序（交换前后不改变该属性）
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
