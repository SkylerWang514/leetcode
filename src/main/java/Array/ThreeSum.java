package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 15
 * @author: Skyler
 * @create: 2024-02-27 16:58
 **/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int target;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            target = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int k = nums.length - 1;
                while (nums[j] + nums[k] > target && k > j) k--;
                if (k == j) {
                    break;
                }
                if (nums[j] + nums[k] == target){
                    List<Integer> integers = new ArrayList<>();
                    integers.add(-target);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    lists.add(integers);
                }
            }
        }
        return lists;
    }
}
