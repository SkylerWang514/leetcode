package mul_dim_dynamic;

/**
 * @program: leetcode
 * @description: 279
 * @author: Skyler
 * @create: 2024-03-12 17:34
 **/

public class NumSquares {
    public int numSquares(int n) {
        int[] leastSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, leastSum[i - j * j] + 1);
            }
            leastSum[i] = min;
        }
        return leastSum[n];
    }
}
