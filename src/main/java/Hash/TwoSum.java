package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 1
 * @author: Skyler
 * @create: 2024-02-29 16:44
 **/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }else map.put(nums[i], i);
        }
        return result;
    }
}
