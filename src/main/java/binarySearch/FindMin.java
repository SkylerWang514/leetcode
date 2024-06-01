package binarySearch;

/**
 * @program: leetcode
 * @description: 153
 * @author: Skyler
 * @create: 2024-03-28 12:28
 **/

public class FindMin {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        int mid = (i + j) /2;
        while (i <= j){
            mid = (i + j) / 2;
            if (nums[mid] > nums[j])
                i = mid + 1;
            else j = mid;
        }
        return nums[i];
    }
}
