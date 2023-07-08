package datastructure.array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int pre = nums[0];
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[j] = nums[i];
                pre = nums[i];
                j++;
            }
        }
        return j;
    }
}
