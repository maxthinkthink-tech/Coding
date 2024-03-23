package algorithm.doublepointer;

public class MaxArea {
    public static void main(String[] args) {
        int[] a =  {1,8,6,2,5,4,8,3,7};
        int r = maxArea(a);
        System.out.println(r);
    }
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int m = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            m = Math.max(m, h * (r-l));
            if (h == height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return m;
    }
}
