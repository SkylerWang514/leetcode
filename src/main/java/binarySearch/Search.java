package binarySearch;

/**
 * @program: leetcode
 * @description: 704
 * @author: Skyler
 * @create: 2024-03-15 11:48
 **/

public class Search {
    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        int mid = -1;
        while (begin <= end){
            mid = (begin + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else begin = mid + 1;
        }
        return -1;
    }
}
