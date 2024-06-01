package skill;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 75
 * @author: Skyler
 * @create: 2024-03-23 16:58
 **/

public class SortColors {
    public void sortColors(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
        
    }
}
