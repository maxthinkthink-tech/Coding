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
}
