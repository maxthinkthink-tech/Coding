package brain;

import java.util.Set;
import java.util.stream.Collectors;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        Set<Character> sSet = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        char[] tArray = t.toCharArray();
        for (int i = 0; i < tArray.length; i++) {
            if (! sSet.contains(tArray[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean res = isAnagram("abc", "a");
        System.out.println("res = " + res);
    }
}
