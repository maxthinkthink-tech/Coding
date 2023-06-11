package datastructure.stack;

import java.util.Queue;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
//        boolean res = isValid("()");
//        System.out.println("res = " + res);
//        String s = simplifyPath("/home/");
//        System.out.println("s = " + s);
//        String[] n = {"4","13","5","/","+"};
//        int v = evalRPN(n);
//        System.out.println("v = " + v);

        int t = calculate("1+2+(3+4)");
        System.out.println("t = " + t);
    }

    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c =String.valueOf(s.charAt(i));
            if (c.equals("(")) {
                stack.push(c);
            } else if (c.equals("+")) {
                stack.push(c);
            } else if (c.equals("-")) {
                stack.push(c);
            }else if (c.equals("*")) {
                stack.push(c);
            }else if (c.equals("/")) {
                stack.push(c);
            } else if (c.equals(")")) {
                String cc = ")";
                while (!cc.equals("(")) {
                    Integer r = Integer.parseInt(stack.pop());
                    String operator = stack.pop();
                    Integer l = Integer.parseInt(stack.pop());
                    if (operator.equals("+")) {
                        r = l + r;
                    } else if (operator.equals("-")) {
                        r = l - r;
                    }

                    cc = stack.peek();
                    if (cc.equals("(")) {
                        stack.pop();
                    }
                    stack.push(r.toString());
                }

            } else {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    char x = s.charAt(i);
                    if (isNumber(x)) {
                        sb.append(x);
                        i++;
                    } else {
                        i--;
                        stack.push(sb.toString());
                        break;
                    }
                }
            }
        }

        while (stack.size() > 1) {
            Integer r = Integer.parseInt(stack.pop());
            String o = stack.pop();
            Integer l = Integer.parseInt(stack.pop());
            if (o.equals("+")) {
                r = l + r;
            }
            if (o.equals("-")) {
                r = l -r;
            }
            stack.push(r.toString());
        }
        return Integer.parseInt(stack.pop());
    }

    public static boolean isNumber(char c) {
        return c == '0' ||
                c == '1' ||
                c == '2' ||
                c == '3' ||
                c == '4' ||
                c == '5' ||
                c == '6' ||
                c == '7' ||
                c == '8' ||
                c == '9'
                ;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;

            } else if (c == ')') {
                Character x = stack.pop();
                if (x != '(') {
                    return false;
                }
                System.out.println(x);

            } else if (c == ']') {
                if (stack.pop() != ']') {
                    return false;
                }

            } else if (c == '}') {
                if (stack.pop() != '}') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static String simplifyPath(String path) {
        if (path.endsWith("/")) {
            path = path.substring(0, path.length() - 1);
        }
        StringBuilder sb = new StringBuilder();

        Stack<String> s = new Stack<>();
        s.push("/");

        String[] sub = path.split("/");
        for (String p : sub) {
            // "//"
            if (p.equals("") || p.equals(".")) {
                if (s.isEmpty()) {
                    s.push("/");
                }
                if (s.peek().equals("/")) {
                    continue;
                } else {
                    continue;
//                    s.push("/");
                }
            } else if (p.equals("..")) {
                if (s.isEmpty()) {
                    s.push("/");
                }
                if (s.peek().equals("/")) {
                    continue;
                } else {
                    s.pop();
                    s.pop();
                }
            } else {
                if (!s.peek().equals("/")) {
                    s.push("/");
                }
                s.push(p);
            }
        }

        for (String value : s) {
            sb.append(value);
        }
        return sb.toString();
    }

    public static Integer evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") ||
                    tokens[i].equals("-") ||
                    tokens[i].equals("*") ||
                    tokens[i].equals("/")) {
                int l = s.pop();
                int r = s.pop();
                if (tokens[i].equals("+")) {
                    r = l + r;
                } else if (tokens[i].equals("-")) {
                    r = l - r;
                } else if (tokens[i].equals("*")) {
                    r = l * r;
                } else if (tokens[i].equals("/")) {
                    r = l / r;
                }
                s.push(r);

            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }

        return s.pop();
    }
}
