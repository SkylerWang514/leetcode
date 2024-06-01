package stack;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 394
 * @author: Skyler
 * @create: 2024-03-18 12:00
 **/

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        StringBuilder bigSb = new StringBuilder();
        int numberOfLeft = 0;
        while (true){
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilderLeft = new StringBuilder();
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] == '[') numberOfLeft++;
                if (sArray[i] == ']'){
                    while (stack.peek() != '['){
                        stringBuilder.append(stack.pop());
                    }
                    stack.pop();

                }else stack.push(sArray[i]);
            }
            if (numberOfLeft == 0) break;
        }
        return "";
    }
}
