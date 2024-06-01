package back;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 78
 * @author: Skyler
 * @create: 2024-03-15 13:48
 **/

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0,nums, result, new ArrayList<>());
        return result;
    }

    public void backTrack(int now, int[] nums, List<List<Integer>> res, List<Integer> nowList){
        res.add(new ArrayList<>(nowList));
        for (int i = now + 1; i < nums.length; i++) {
            nowList.add(nums[i]);
            backTrack(i + 1, nums, res, nowList);
            nowList.remove(nowList.size() - 1);
        }
    }
}
