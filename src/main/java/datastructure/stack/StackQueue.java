package datastructure.stack;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> s = new Stack<>();

    public void enqueue(Integer i) {
        Stack<Integer> tmp = new Stack<>();
        while (!s.isEmpty()) {
            tmp.push(tmp.pop());
        }
        tmp.push(i);

        while (!tmp.isEmpty()) {
            s.push(tmp.pop());
        }
    }

    public Integer dequeue() {
        if (s.isEmpty()) {
            return null;
        }
        return s.pop();
    }
}
