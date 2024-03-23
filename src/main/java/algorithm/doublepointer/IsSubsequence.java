package algorithm.doublepointer;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        boolean r = isSubsequence(s, t);
        System.out.println(r);
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
