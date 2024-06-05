package Calculation;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 20
 * @author: Skyler
 * @create: 2024-02-05 21:44
 **/

public class brackets {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char nowPeek = stack.peek();
                if (isCouple(nowPeek, c)) stack.pop();
                else stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isCouple(char before, char after){
        return (before == '(' && after == ')') || (before == '{' && after == '}') || (before == '[' && after == ']');
    }


    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }
}
