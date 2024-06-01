package Calculation;

import com.google.common.primitives.Ints;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: leetcode 27
 * @author: Skyler
 * @create: 2024-01-14 16:03
 **/

public class Remove {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] nums2 = new int[nums.length];
        nums2 = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.out.println(Arrays.toString(nums2));
        for (int i = 0; i < nums.length - k - 2; i++){
            nums2[i + k] = nums[i];
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
