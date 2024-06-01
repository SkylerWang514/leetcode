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
        Stack<Character> characterStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isBracket(c)){
                if (characterStack.isEmpty()){
                    characterStack.push(c);
                }
                else {
                    char a = characterStack.peek();
                    if (isPair(a, c)){
                        characterStack.pop();
                    }else characterStack.push(c);
                }
            }
        }
        return characterStack.isEmpty();
    }

    public static boolean isBracket(char c){
        return (int) c == 40 || (int) c == 41 || (int) c == 91 || (int) c == 93 || (int) c == 123 || (int) c == 125;
    }

    public static boolean isPair(char a, char b){
        return ((int) a == 40 && (int) b == 41) || ((int) a == 91 && (int) b == 93) || ((int) a == 123 && (int) b == 125);
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[)"));
    }
}
