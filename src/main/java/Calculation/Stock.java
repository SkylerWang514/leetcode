package Calculation;

/**
 * @program: leetcode
 * @description: 121
 * @author: Skyler
 * @create: 2024-01-18 22:46
 **/

public class Stock {
    public static int maxProfit1(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i <= prices.length - 1; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return Math.max(maxProfit, 0);
    }

    public static int maxProfit(int[] prices) {
        int all_profit = 0;
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i = 0; i <= prices.length - 1; i++) {
            System.out.println("price_i:" + prices[i]);
            if (prices[i] < prices[i - 1]){
                if (maxProfit > 0) {
                    System.out.println("all_profit:" + all_profit);
                    System.out.println("maxProfit:" + maxProfit);
                    all_profit += maxProfit;
                    maxProfit = 0;
                }
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;

        }
        if (maxProfit > 0) {
            System.out.println("all_profit:" + all_profit);
            System.out.println("maxProfit:" + maxProfit);
            all_profit += maxProfit;
        }
        return Math.max(all_profit, 0);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
