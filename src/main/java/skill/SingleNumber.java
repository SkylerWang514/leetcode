package skill;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 136
 * @author: Skyler
 * @create: 2024-03-17 17:27
 **/

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = 0, re = 0;
        while (j < nums.length){
            while (j < nums.length && nums[j] == nums[i]) j++;
            if (j - i == 1){
                re = nums[i];
                break;
            }
            i = j;
            j = i;
        }
        return re;
    }
}
