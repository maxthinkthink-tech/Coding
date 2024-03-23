package algorithm.doublepointer;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean r = isPalindrome(s);
        System.out.println(r);
    }
    public static boolean isPalindrome(String s) {
        int l =0;
        int r = s.length()-1;
        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l)) && l < r) {
                l++;
            }
            while (!Character.isLetterOrDigit(s.charAt(r)) && l < r) {
                r--;
            }

            if (!(Character.toLowerCase(s.charAt(l++)) == Character.toLowerCase(s.charAt(r--)))) {
                return false;
            }
        }
        return true;
    }
}
