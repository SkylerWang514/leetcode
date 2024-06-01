package String;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 415
 * @author: Skyler
 * @create: 2024-03-10 12:19
 **/
// 0-9 48-57
public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int a = num1.length() - 1, b = num2.length() - 1, add = 0;
        int x, y, new1;
        StringBuffer stringBuffer = new StringBuffer();
        while (a >= 0 || b >= 0 || add != 0){
            x = a >= 0 ? num1Char[a] -'0' : 0;
            y = b >= 0 ? num2Char[b] -'0' : 0;
            new1 = (x + y + add) % 10;
            add = (x + y + add) / 10;
            stringBuffer.append(new1);
            a--;
            b--;
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println((int)'1');
        System.out.println((int)'2');
        System.out.println((int)'9');
        System.out.println((int)'0');
    }
}
