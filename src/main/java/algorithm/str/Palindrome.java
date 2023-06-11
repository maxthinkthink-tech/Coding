package algorithm.str;

public class Palindrome {
    public static void main(String[] args) {
        String s = "0P";
        boolean r = isPalindrome(s);
        System.out.println(r);
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            //Character.isLetterOrDigit(c);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        s = sb.toString().toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
