package datastructure.stack;

import java.util.Stack;

public class IsValidBrackets {
    public static void main(String[] args) {
        boolean r = isValid("()");
        System.out.println(r);
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else  if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else {
                stack.push(c);
            }
            i++;
        }
        return stack.isEmpty();
    }
}
