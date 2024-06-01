package twoPointer;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 283
 * @author: Skyler
 * @create: 2024-03-15 15:16
 **/

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int i = 0, j = 0, zero = i;
        while (i < nums.length && nums[i] != 0) i++;
        if (i == nums.length - 1) return;
        j = i;
        while (j < nums.length){
            if (nums[j] != 0 && j != i){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            j++;
        }
    }
}
