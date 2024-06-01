package Array;

/**
 * @program: leetcode
 * @description: 13
 * @author: Skyler
 * @create: 2024-03-20 13:23
 **/

public class romanToInt {
    public int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");
        int sum = 0;
        for (char c:
             s.toCharArray()) {
            sum += getValue(c);
        }
        return sum;
    }
    public int getValue(char c){
        switch (c){
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
