package algorithm.dp.IntervalDP;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        Map<String, Integer> map = new HashMap<>();
        return helper(s, 0, s.length() - 1, map);
    }

    public static int helper(String s, int start, int end, Map<String, Integer> map) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        String key = String.format("%s,%s", start, end);
        if (null != map.get(key)) {
            return map.get(key);
        }

        if (s.charAt(start) == s.charAt(end)) {
            int res = helper(s, start + 1, end - 1, map) + 2;
            map.put(key, res);
            return res;
        } else {
            int res = Math.max(helper(s, start + 1, end, map), helper(s, start, end - 1, map));
            map.put(key, res);
            return res;
        }
    }

    public int longestPalindromeSubseqFromLabuladong(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        dp[0][0] = 1;

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                dp[i][i] = 1;
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }

    public int longestPalindromeSubseqFromLeetCode(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n -1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);

            for (int j = i+1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
