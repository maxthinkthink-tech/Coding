package algorithm.array;

public class RemoveElement {
    public static void main(String[] args) {
        int[] a = {3,2,2,3};
        int r = removeElement(a, 3);
        System.out.println(r);
    }
    public static int removeElement(int[] nums, int val) {
        int l = 0;
        int r = 0;
        while(r < nums.length) {
            if (nums[r] == val) {
                r++;
                continue;
            }
            nums[l++] = nums[r++];
        }
        return l;
    }
}
