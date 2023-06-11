package algorithm.array;

public class Gas {
    public static void main(String[] args) {
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        int res = test(gas, cost);
        System.out.println("res = " + res);
    }
    public static int test(int[] gas, int[] cost) {
        int b = -1;
        for (int x = 0; x < gas.length; x++) {
            if (gas[x] < cost[x]) {
                continue;
            }
            b = x;
            int g = 0;
            while (g + gas[x] - cost[x] >= 0) {
                g = g + gas[x] - cost[x];
                x++;
                x = x % gas.length;
                if (x == b) {
                    return b;
                }
            }
            if (x < b) {
                return  -1;
            }
            if (g + gas[x] - cost[x] < 0) {
                if (x == b) {
                    return -1;
                } else {
                    x--;
                }
            }
        }
        return -1;
    }
}