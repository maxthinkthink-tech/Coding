package datastructure.array;

public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int pre = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                pre = pre + 1;
                if (max < pre) {
                    max = pre;
                }
            } else {
                pre = 1;
            }
        }
        return max;
    }
}
