package Array;

import java.util.*;

/**
 * @program: leetcode
 * @description: 53
 * @author: Skyler
 * @create: 2024-03-07 20:44
 **/

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int a:
             nums) {
            pre = Math.max(pre, pre + a);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
