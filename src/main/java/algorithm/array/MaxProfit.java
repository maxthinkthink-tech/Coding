package algorithm.array;

public class MaxProfit {
    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int r = maxProfit(a);
        System.out.println(r);
    }
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            // 使用 else if 的条件是 当前i 不是最小值,如果是最小值收益为0,不需要在这里计算.
            else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
