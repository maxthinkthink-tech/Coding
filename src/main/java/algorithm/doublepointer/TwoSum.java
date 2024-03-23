package algorithm.doublepointer;

public class TwoSum {
    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int[] r = twoSum(a, 9);
        System.out.printf("%d,%d", r[0], r[1]);
    }
    public static  int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        int s = 0;
        while (l < r) {
            s = numbers[l] + numbers[r];
            if (s == target) {
                return new int[] {l+1, r+1};
            } else if (s > target) {
                r--;
            } else {
                l++;
            }

        }
        return new int[] {0, 0};
    }
}
