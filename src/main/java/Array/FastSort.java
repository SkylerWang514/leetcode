package Array;

import org.springframework.http.converter.json.GsonBuilderUtils;

import javax.crypto.spec.PSource;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 912
 * @author: Skyler
 * @create: 2024-03-07 22:02
 **/

public class FastSort {
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int begin, int end){
        if (begin < end){
            int x = partition(nums, begin, end);
            quickSort(nums, begin, x - 1);
            quickSort(nums, x + 1, end);
        }
    }

    public static int partition(int[] nums, int begin, int end){
        int flag = nums[begin];
        int be = begin + 1;
        int en = end;
        while (be <= en){
            while (be <= en && nums[be] <= flag) be++;
            while (be <= en && nums[en] >= flag) en--;
            if (be <= en){
                swap(nums, be, en);
                be++;
                en--;
            }
        }
        swap(nums, be - 1, begin);
        return be - 1;
    }

    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] array = {79, 6, 945, 34, 20, 76, 16};
        quickSort(array, 0, array.length - 1);
    }
}
