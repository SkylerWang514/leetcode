package Calculation;

import io.swagger.models.auth.In;
import lombok.var;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 228
 * @author: Skyler
 * @create: 2024-02-06 18:15
 **/

public class Range {
    public static List<String> summaryRanges(int[] nums) {
        List<String> stringList = new ArrayList<>();
        if (nums.length == 0) return stringList;
        int begin = nums[0];
        int end = nums[0];
        int low = 0, high = 1;
        while (low < nums.length){
            if (high >= nums.length){
                end = nums[low];
                if (begin == end) stringList.add(""+begin);
                else stringList.add(begin + "->" + end);
            }else {
                if (nums[high] > 1 + nums[low]) {
                    end = nums[low];
                    if (begin == end) stringList.add("" + begin);
                    else stringList.add(begin + "->" + end);
                    begin = nums[high];
                }
            }
            high++;
            low++;
        }
        return stringList;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
//        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
