package algorithm.basic;

import java.util.Stack;

public class PolishNotation {
    public static void main(String[] args) {
        String x = "- + + + * 3 4 2 1 / * 5 6 2 8";
        String[] xa = x.split(" ");

        String[] input = {"-", "+", "*", "1", "2", "3", "1"};
        input = xa;
//        input = {- + + + * 3 4 2 1 / * 5 6 2 8};
        Stack<String> s = new Stack<>();
        String r = null;
        for (int i = 0; i < input.length; i++) {
            if (isOperator(input[i])) {
                s.push(input[i]);
                continue;
            }
            r = input[i];
            while (!isOperator(r) && !s.isEmpty()) {
                String l = s.pop();
                if (!isOperator(l)) {
                    String o = s.pop();
                    Float tmp = 0.0F;
                    if (o.equals("+")) {
                        tmp = Float.parseFloat(r) + Float.parseFloat(l);;
                    }
                    if (o.equals("-")) {
                        tmp = Float.parseFloat(l) - Float.parseFloat(r);;
                    }
                    if (o.equals("*")) {
                        tmp = Float.parseFloat(r) * Float.parseFloat(l);;
                    }
                    if (o.equals("/")) {
                        tmp = Float.parseFloat(l) / Float.parseFloat(r);
                    }
                    s.push(tmp.toString());
                } else {
                    s.push(l);
                    s.push(r);
                    break;
                }
                r = s.pop();
            }
        }
        System.out.println(r);
    }

    public static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }
}