package mul_dim_dynamic;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 32
 * @author: Skyler
 * @create: 2024-03-29 12:21
 **/

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        s = " " + s;
        int[] dp = new int[s.length()];// 以i结尾的最长有效括号长度
        int maxLen = 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
                maxLen = Math.max(maxLen, dp[i]);

            }
        }
        return maxLen;

    }
}
