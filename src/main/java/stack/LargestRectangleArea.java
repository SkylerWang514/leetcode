package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 84
 * @author: Skyler
 * @create: 2024-03-16 15:17
 **/

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            if (i == 0 || heights[i] > heights[i - 1])
                stack.push(heights[i]);
        }
        stack.clear();
        for (int i = heights.length - 1; i > 0; i--) {
            right[i] = stack.isEmpty() ? -1 : stack.peek();
            if (i == heights.length - 1 || heights[i] > heights[i + 1])
                stack.push(heights[i]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return 1;
    }
}
