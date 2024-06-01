package mul_dim_dynamic;

/**
 * @program: leetcode
 * @description: 62
 * @author: Skyler
 * @create: 2024-03-21 20:50
 **/

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m - 1; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n - 1; i++)
            dp[0][n] = 1;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
