package matrix;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 240
 * @author: Skyler
 * @create: 2024-03-29 12:35
 **/

public class SearchMatrix {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temperatureStack = new Stack<>();
        Stack<Integer> temperaturePointStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (temperatureStack.size() == 0 || temperatureStack.peek() <= temperatures[i]){
                while (temperatureStack.size() != 0 && temperatureStack.peek() <= temperatures[i]){
                    temperatureStack.pop();
                    temperaturePointStack.pop();
                }
                if (temperaturePointStack.size() != 0) result[i] = temperaturePointStack.peek() - i;
                else result[i] = 0;
                temperatureStack.push(temperatures[i]);
                temperaturePointStack.push(i);
            }else {
                result[i] = temperaturePointStack.peek() - i;
                temperatureStack.push(temperatures[i]);
                temperaturePointStack.push(i);
            }
            System.out.println(temperatureStack);
            System.out.println(temperaturePointStack);
        }
        return result;
    }
}
