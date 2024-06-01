package mul_dim_dynamic;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 152
 * @author: Skyler
 * @create: 2024-03-20 13:39
 **/

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        int length = nums.length;
        int nowMax, nowMin;
        for (int i = 0; i < length; i++) {
            nowMax = max;
            nowMin = min;
            max = Math.max(nums[i], Math.max(nums[i] * nowMax, nums[i] * nowMin));
            min = Math.min(nums[i], Math.min(nums[i] * nowMax, nums[i] * nowMin));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
