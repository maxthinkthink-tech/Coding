package algorithm.array;

public class MaxProfit2 {
    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int r = maxProfit(a);
        System.out.println(r);
    }
    public static int maxProfit(int[] prices) {
        int s = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                s += prices[i] - prices[i-1];
            }
        }
        return s;
    }
}
