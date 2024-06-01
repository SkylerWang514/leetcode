package sonArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 560
 * @author: Skyler
 * @create: 2024-03-11 15:16
 **/

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 前缀树map
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0, sum = 0;
        map.put(0,1);
        for (int num : nums) {
            prefix += num;
            if (map.containsKey(prefix - k)) sum += map.get(prefix - k);
            if (map.containsKey(prefix)) map.computeIfPresent(prefix, (key, v) -> v = v + 1);
            else map.put(prefix, 1);
        }
        return sum;
    }
}
