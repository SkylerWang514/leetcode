package mul_dim_dynamic;

/**
 * @program: leetcode
 * @description: 416
 * @author: Skyler
 * @create: 2024-03-28 11:31
 **/

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:
             nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        int[] bag = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j > num; j--) {
                bag[j] = Math.max(bag[j - num] + num, bag[j]);
            }
        }
        return bag[target] == target;
    }
}
