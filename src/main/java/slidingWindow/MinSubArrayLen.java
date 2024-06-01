package slidingWindow;

/**
 * @program: leetcode
 * @description: 209
 * @author: Skyler
 * @create: 2024-02-15 09:54
 **/

public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target){
                    ans = Math.min(j - i + 1, ans);
                    while (i < j && sum >= target){
                        sum -= nums[i];
                        i++;
                    }
                    if (sum < target) i--;
                    if (i != j) ans = Math.min(j - i + 1, ans);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
