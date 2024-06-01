package stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 232
 * @author: Skyler
 * @create: 2024-03-15 12:07
 **/

public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (!out.isEmpty()) return out.pop();
        else moveInToOut();
        return out.pop();
    }

    public int peek() {
        if (!out.isEmpty()) return out.peek();
        else moveInToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public void moveInToOut(){
        while (!in.isEmpty()){
            out.push(in.pop());
        }
    }
}
