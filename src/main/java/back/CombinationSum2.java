package back;

import java.util.*;

/**
 * @program: leetcode
 * @description: 40
 * @author: Skyler
 * @create: 2024-03-25 12:10
 **/

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> integerList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0, integerList);
        return integerList;
    }

    private void backtrack(int[] candidates, int target, List<Integer> combination, int start, List<List<Integer>> result) {
        if (target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] <= target){
                combination.add(candidates[i]);
                backtrack(candidates, target - candidates[i], combination, i + 1, result);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
