package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description: 46
 * @author: Skyler
 * @create: 2024-03-08 21:45
 **/

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int n:
             nums) {
            integers.add(n);
        }
        List<List<Integer>> lists = new ArrayList<>();
        generate(0, nums.length, lists, integers);
        return lists;

    }
    public void generate(int now, int length, List<List<Integer>> lists, List<Integer> nums){
        if (now == length){
            lists.add(new ArrayList<>(nums));
        }
        for (int i = now; i < length; i++) {
            Collections.swap(nums, now, i);
            generate(now + 1, length, lists, nums);
            Collections.swap(nums, now, i);
        }
    }
    public void change(List<Integer> list, int a, int b){
        Integer temp = list.get(a);
        list.set(b, list.get(a));
        list.set(a, temp);
    }
}
