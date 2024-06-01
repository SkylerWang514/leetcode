package Array;

/**
 * @program: leetcode
 * @description: 33
 * @author: Skyler
 * @create: 2024-02-27 16:10
 **/

public class SearchRotate {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1 && nums[0] == target) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            System.out.println(mid);
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[n - 1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
