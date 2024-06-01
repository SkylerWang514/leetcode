package binarySearch;

/**
 * @program: leetcode
 * @description: 35
 * @author: Skyler
 * @create: 2024-02-13 19:56
 **/

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            if (target <= nums[mid]){
                ans = mid;
                right = mid;
            }else left = mid;
        }
        return ans;
    }

}
