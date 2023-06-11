package algorithm.dp;

public class SuperEggDrop {
    public static void main(String[] args) {
        int res = computeResult_KNN(2, 2);
        System.out.println("res = " + res);
    }

    /**
     * 计算k个鸡蛋、n层楼的扔鸡蛋总次数
     *
     * @param k 鸡蛋个数
     * @param n 楼层数
     * @return 扔鸡蛋总次数
     */
    private static int computeResult_KNN(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                // 鸡蛋、楼层为零时， 扔鸡蛋次数也为0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                // 1个鸡蛋情况下， 扔鸡蛋次数等于楼层数
                else if (i == 1) {
                    dp[i][j] = j;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // [1 ... k] 个鸡蛋
        for (int i = 1; i <= k; i++) {
            // 【1 ... n】个楼层
            for (int j = 1; j <= n; j++) {
                // 逐个楼层扔
                for (int l = 1; l <= j; l++) {
                    int currentRes = Math.max(dp[i][j - l], dp[i - 1][l - 1]) + 1;
                    if (currentRes < dp[i][j]) {
                        dp[i][j] = currentRes;
                    }
                }
            }
        }
        return dp[k][n];
    }


    /**
     * 计算k个鸡蛋、n层楼的扔鸡蛋总次数
     *
     * @param k 鸡蛋个数
     * @param n 楼层数
     * @return 扔鸡蛋总次数
     */
    private static int computeResult_KNLogN(int k, int n) {
        // 初始化数据
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        // [1 ... k] 个鸡蛋
        for (int i = 1; i <= k; i++) {
            // 【1 ... n】个楼层
            for (int j = 1; j <= n; j++) {
                // 逐个楼层扔
                for (int l = 1; l <= j; l++) {
                    int currentRes = Math.max(dp[i][j - l], dp[i - 1][l - 1]) + 1;
                    if (currentRes < dp[i][j]) {
                        dp[i][j] = currentRes;
                    }
                }
            }
        }
        return dp[k][n];
    }

}