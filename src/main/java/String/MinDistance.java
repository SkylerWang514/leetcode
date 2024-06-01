package String;

/**
 * @program: leetcode
 * @description: 72
 * @author: Skyler
 * @create: 2024-03-10 16:13
 **/

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int left, down, left_down;
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                left = dp[i - 1][j];
                down = dp[i][j - 1];
                left_down = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.max(Math.max(left, down), left_down);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
