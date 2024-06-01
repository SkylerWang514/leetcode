package stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @program: leetcode
 * @description: 155
 * @author: Skyler
 * @create: 2024-03-15 12:34
 **/

public class MinStack {
    Stack<Integer> stack;
    Map<Integer, Integer> integers;
    Deque<Integer> integerDeque = new LinkedList<>();
    int min;

    public MinStack() {
        stack = new Stack<>();
        integers = new TreeMap<>();
        min = 0;
    }

    public void push(int val) {
        stack.push(val);
        if (integers.containsKey(val)) integers.computeIfPresent(val, (k, v) -> v = v + 1);
        else integers.put(val, 1);
    }

    public void pop() {
        int a = stack.pop();
        integers.computeIfPresent(a, (k, v) -> v = v - 1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        Iterator<Map.Entry<Integer, Integer>> iterator = integers.entrySet().iterator();
        Map.Entry<Integer, Integer> firstEntry = iterator.next();
        while (firstEntry.getValue() <= 0)  firstEntry = iterator.next();
        return firstEntry.getKey();
    }
}
