package Array;

/**
 * @program: leetcode
 * @description: 238
 * @author: Skyler
 * @create: 2024-02-29 17:11
 **/

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int mul = 1;
        pre[0] = mul;
        for (int i = 1; i < nums.length; i++) {
            mul *= nums[i - 1];
            pre[i] = mul;
        }
        mul = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            mul *= nums[i + 1];
            pre[i] *= mul;
        }
        return pre;
    }
}
