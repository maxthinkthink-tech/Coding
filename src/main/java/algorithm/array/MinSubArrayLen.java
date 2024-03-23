package algorithm.array;

public class MinSubArrayLen {
    public static void main(String[] args) {
//        System.out.printf("%s,%s", 1, 1);
//        Integer.MAX_VALUE;
        int[] a = {2,3,1,2,4,3};
        // result: 2, 4+3 = 7
        int r = minSubArrayLen(7, a);
        System.out.println(r);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int s = 0;
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        while (r < nums.length) {
            s += nums[r++];
            while(s >= target) {
                min = Math.min(min, r-l);
                s = s - nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
