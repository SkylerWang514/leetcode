package binarySearch;

/**
 * @program: leetcode
 * @description: 74
 * @author: Skyler
 * @create: 2024-02-14 21:00
 **/

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int length = m * n;
        int[] nums = new int[length];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, nums, i * n, n);
        }
        return searchInsert(nums, target) != -1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (target == nums[mid]){
                ans = mid;
            }else if (target < nums[mid]) right = mid - 1;
            else if (target > nums[mid]) left = mid + 1;
        }
        return ans;
    }
}
