package Calculation;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 66
 * @author: Skyler
 * @create: 2024-02-10 16:41
 **/

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits[0] == 0) return new int[]{1};
        if (digits[digits.length - 1] != 9){
            digits[digits.length - 1] += 1;
            return digits;
        }
        if (digits.length == 1 && digits[0] == 9) return new int[]{1, 0};
        for (int i = digits.length - 1; i > 0; i--) {
            digits[i] = 0;
            if (digits[i - 1] != 9){
                digits[i - 1] += 1;
                return digits;
            }
            if (digits[i - 1] == 9 && i - 1 == 0){
                int[] begin = new int[digits.length + 1];
                digits[i - 1] = 0;
                begin[0] = 1;
                System.arraycopy(digits, 0, begin, 1, digits.length - 1);
                return begin;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
}
