package Array;

/**
 * @program: leetcode
 * @description: 300
 * @author: Skyler
 * @create: 2024-03-10 12:59
 **/

public class LengthOfLIS {
    // 动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAnswer = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxAnswer = Math.max(maxAnswer, dp[i]);
        }
        for (int n:
             dp) {
            maxAnswer = Math.max(maxAnswer, n);
        }
        return maxAnswer;
    }
}
