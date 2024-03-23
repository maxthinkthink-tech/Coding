package algorithm.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {-1,0,3,5,9,12};
        int r = search(a, 9);
        System.out.println(r);
    }
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
