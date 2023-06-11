package datastructure.array;

public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length;
        int i = 0;
        while (zero < two) {
            if (nums[i] == 0) {
                swap(nums, zero, i);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, two, i);
            }
        }
    }
    public void swap(int[] nums, int l, int r) {
        int tmp = nums[r];
        nums[r] = nums[l];
        nums[l] = tmp;
    }
}
