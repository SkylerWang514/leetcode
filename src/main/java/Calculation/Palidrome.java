package Calculation;

/**
 * @program: leetcode
 * @description: leetcode 125
 * @author: Skyler
 * @create: 2024-02-01 15:30
 **/

public class Palidrome {
    public static boolean isPalindrome(String s){
        int length = s.length();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a)){
                stringBuffer.append(Character.toLowerCase(a));
            }
        }
        return stringBuffer.toString().equals(stringBuffer.reverse().toString());
    }
    public static boolean isPalindrome1(String s) {
        String lowercaseStr = s.toLowerCase();
        String cleanedStr = lowercaseStr.replaceAll("[^a-zA-Z0-9]", "");
        int length = cleanedStr.length();
        if (cleanedStr.isEmpty() || cleanedStr.equals(" ")) return true;
        for (int i = 0; i <= (length - 1) / 2; i++) {
            char a = cleanedStr.charAt(i);
            char b = cleanedStr.charAt(length - 1 - i);
//            System.out.println(a + " " + b);
            if ((int)a != (int)b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("."));
    }
}
