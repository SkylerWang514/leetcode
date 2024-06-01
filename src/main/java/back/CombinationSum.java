package back;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 39
 * @author: Skyler
 * @create: 2024-03-17 15:10
 **/

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getList(lists, list, 0, candidates, target);
        return lists;
    }

    public void getList(List<List<Integer>> lists, List<Integer> list, int i, int[] set, int target){
        if (target < 0) return;
        else if (target == 0) lists.add(new ArrayList<>(list));
        else {
            for (int j = i; j < set.length; j++) {
                list.add(set[j]);
                getList(lists, list, j, set, target - set[j]);
                list.remove(list.size() - 1);
            }
        }
    }
}
