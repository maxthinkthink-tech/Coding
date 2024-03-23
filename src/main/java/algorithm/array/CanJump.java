package algorithm.array;

public class CanJump {
    public static void main(String[] args) {
        int[] a = {3,2,1,0,4};
        boolean r = canJump(a);
        System.out.println(r);
    }
    public static boolean canJump(int[] nums) {
        int rightmost = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
