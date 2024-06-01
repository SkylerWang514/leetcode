package mul_dim_dynamic;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 322
 * @author: Skyler
 * @create: 2024-03-12 17:41
 **/

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        for (int coin:
             coins) {
            if (coin <= amount)
                array[coin] = 1;
        }
        if (amount == coins[coins.length - 1]) return 1;
        for (int i = 1; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin:
                 coins) {
                if (i - coin >= 0)
                    min = Math.min(min, array[i - coin] != Integer.MAX_VALUE ? array[i - coin] + 1 : Integer.MAX_VALUE);
            }
            array[i] = min;
        }
        System.out.println(Arrays.toString(array));
        return array[amount] == Integer.MAX_VALUE || array[amount] == 0 ? -1 : array[amount];
    }
}
