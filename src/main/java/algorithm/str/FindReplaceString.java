package algorithm.str;

import java.util.Arrays;

public class FindReplaceString {
    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"ab","ec"};
        String[] targets= {"eee","ffff"};
        String r = findReplaceString(s, indices, sources, targets);
        System.out.println(r);
    }
    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            String ss = sources[i];
            int j = 0;
            for (; j < ss.length(); j++) {
                if (ss.charAt(j) == s.charAt(indices[i]+j)) {
                    continue;
                } else {
                    break;
                }
            }
            if (j == ss.length()) {
                sb.append(targets[i]);
                if (i < indices.length - 1) {
                    String t = s.substring(indices[i] + ss.length(), indices[i+1]);
                    sb.append(t);
                }
            } else {
                String t = s.substring(indices[i], indices[i]+ss.length());
                sb.append(t);
            }
        }
        return sb.toString();
    }
}
