package Array;

/**
 * @program: leetcode
 * @description: 88
 * @author: Skyler
 * @create: 2024-03-09 20:00
 **/

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) System.arraycopy(nums2, 0, nums1, 0, n);
        else if (n == 0) {
        }
        else {
            int begin1 = m - 1, begin2 = n - 1, flag = m + n - 1;
            int now = nums1[begin1];
            while (begin1 > 0 && begin2 > 0){
                if (nums1[begin1] > nums2[begin2]) now = nums1[begin1--];
                else now = nums2[begin2--];
                System.out.println(now);
                nums1[flag--] = now;
            }
            if (begin2 > 0) System.arraycopy(nums2, 0, nums1, 0, begin2);
        }
    }
}
