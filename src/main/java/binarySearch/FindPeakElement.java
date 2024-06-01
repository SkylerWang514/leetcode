package binarySearch;

/**
 * @program: leetcode
 * @description: 162
 * @author: Skyler
 * @create: 2024-02-28 14:39
 **/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        int mid = (i + j) / 2;
        while (i < j){
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < mid) return mid;
            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]){
                if (nums[i] > nums[mid - 1]) j = mid - 1;
                else i = mid + 1;
            }else{
                if (nums[i] < nums[mid - 1]) j = mid - 1;
                else i = mid + 1;
            }
        }
        return mid;
    }
}
