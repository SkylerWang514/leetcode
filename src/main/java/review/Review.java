package review;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-01-14 15:36
 **/

public class Review {
    public static int partition(int[] array, int begin, int end){
        int key = array[end];
        int i = begin;
        int j = end - 1;
        while (i <= j){
            while (i <= j && array[j] >= key) j--;
            while (i <= j && array[i] <= key) i++;
            if (i <= j){
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, j + 1, end);
        return j + 1;
    }
    public static void quickSort(int[] array, int begin, int end){
        if (begin < end){
            int mid = partition(array, begin, end);
            quickSort(array, begin, mid - 1);
            quickSort(array, mid + 1, end);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {79, 6, 945, 34, 20, 76, 16};
        quickSort(array, 0, array.length - 1);
        System.out.println("排序结果：");
        System.out.println(Arrays.toString(array));
    }
}
