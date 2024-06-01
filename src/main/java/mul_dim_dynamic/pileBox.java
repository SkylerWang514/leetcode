package mul_dim_dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 。
 * @author: Skyler
 * @create: 2024-04-05 17:38
 **/

public class pileBox {
    public int pileBox(int[][] box) {
        Arrays.sort(box, (x, y) -> {
            if (x[0] == y[0]){
                if (x[1] == y[1]){
                    return y[2] - x[2];
                }else return y[1] - x[1];
            }else return y[0] - x[0];
        });
        int[] dp = new int[box.length];
        int res = box[0][2];
        dp[0] = box[0][2];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2])
                    dp[i] = Math.max(dp[j], dp[i]);
            }
            dp[i] += box[i][2];
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
