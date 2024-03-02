package algorithm.array;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = new int[] {1,2};
        int l = removeDuplicates(a);
        System.out.println(l);
        Arrays.stream(a).mapToObj(x -> x  + " ").forEach(System.out::print);
    }

    public static int removeDuplicates(int[] nums) {
        int s = 0;
        int f = 0;
        for (; f < nums.length; f++) {
            if (nums[s] != nums[f]) {
                nums[++s] = nums[f];
            } else {
                if (s >= 1 && nums[s-1] == nums[s] ) {
                    continue;
                } else {
                    nums[++s] = nums[f];
                }
            }
        }
        return s + 1;
    }
}
