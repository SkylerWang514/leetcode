package Array;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 42
 * @author: Skyler
 * @create: 2024-03-10 13:49
 **/

public class Trap {
    public int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] final1 = new int[length];
        int maxHeight = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > maxHeight){
                left[i] = 0;
                maxHeight = height[i];
            }else {
                left[i] = maxHeight - height[i];
            }
        }
        maxHeight = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (height[i] > maxHeight){
                right[i] = 0;
                maxHeight = height[i];
            }else {
                right[i] = maxHeight - height[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            sum += Math.min(left[i], right[i]);
        }
        return sum;
    }
}
