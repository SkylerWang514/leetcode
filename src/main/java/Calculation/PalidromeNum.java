package Calculation;

/**
 * @program: leetcode
 * @description: 9
 * @author: Skyler
 * @create: 2024-02-08 11:04
 **/

public class PalidromeNum {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        String s = String.valueOf(x);
        int length = s.length() / 2;
        char[] chars = s.toCharArray();
        char a = ' ';
        char b = ' ';
        for (int i = 0; i < length; i++) {
            a = chars[i];
            b = chars[s.length() - 1 - i];
            if ((int)a != (int)b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(894656498));
    }
}
