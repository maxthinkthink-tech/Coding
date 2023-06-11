package algorithm.array;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = new int[] {1,1,1,2,2,3};
        int l = removeDuplicates(a);
        System.out.println(l);
        Arrays.stream(a).mapToObj(x -> x  + " ").forEach(System.out::print);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int s = 2;
        int f = 2;
        while (f < nums.length) {
            if (nums[s-2] != nums[f]) {
                nums[s++] = nums[f];
            }
            f++;
        }
        return s;
    }
}
