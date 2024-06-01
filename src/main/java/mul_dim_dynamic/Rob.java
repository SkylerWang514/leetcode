package mul_dim_dynamic;

/**
 * @program: leetcode
 * @description: 198
 * @author: Skyler
 * @create: 2024-03-12 17:11
 **/

public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int pre1 = nums[0], pre2 = Math.max(nums[0], nums[1]);
        int cur = 0;
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }
}
