package binarySearch;

/**
 * @program: leetcode
 * @description: 34
 * @author: Skyler
 * @create: 2024-03-18 19:42
 **/

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1, mid = (i + j) / 2;
        while (i <= j){
            mid = (i + j) / 2;
            if (nums[mid] == target) break;
            else if (nums[mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        if (i > j) return new int[]{-1, -1};
        int left = mid, right = mid;
        while (left >= 0 && nums[left] == target) left--;
        while (right <= nums.length - 1 && nums[right] == target) right++;
        return new int[]{left + 1, right - 1};
    }
}
