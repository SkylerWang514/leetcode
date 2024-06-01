package Array;

/**
 * @program: leetcode
 * @description: 41
 * @author: Skyler
 * @create: 2024-03-27 15:42
 **/

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
               swap(nums, i, nums[i] - 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return nums[nums.length - 1] + 1;
    }

    public void swap(int[] num, int l, int r){
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }
}
