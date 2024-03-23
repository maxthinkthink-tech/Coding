package algorithm.basic;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int m = (l+r) / 2;
        while (l < r) {
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target ) {
                l = m + 1;
            }
            if (nums[m] > target) {
                r = m;
            }
            m = (l+r)/2;
        }
        return -1;
    }
}
