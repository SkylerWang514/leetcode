package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 2007
 * @author: Skyler
 * @create: 2024-04-18 11:39
 **/

public class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int[] ans = new int[changed.length / 2];
        int ansIdx = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : changed) {
            if (!cnt.containsKey(x)) { // x 不是双倍后的元素
                if (ansIdx == ans.length) {
                    return new int[0];
                }
                ans[ansIdx++] = x;
                cnt.merge(x * 2, 1, Integer::sum); // 标记一个双倍元素
            } else { // x 是双倍后的元素
                int c = cnt.merge(x, -1, Integer::sum); // 清除一个标记
                if (c == 0) {
                    cnt.remove(x);
                }
            }
        }
        return ans;
    }
}
