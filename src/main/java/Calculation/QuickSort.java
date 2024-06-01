package Calculation;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 快速排序
 * @author: Skyler
 * @create: 2024-01-11 20:36
 **/

public class QuickSort {

    public static int partition(int[] array, int begin, int end) {
        int key = array[end];
        // 前后指针法
//        for (int i = begin + 1; i < end; i++){
//            int j = i + 1;
//            if (i == end)
//        }
        // 左右指针法
        int i = begin;
        int j = end - 1;
        while (i <= j) {
            while (i <= j && array[j] > key) j--;
            while (i <= j && array[i] < key) i++;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println(i);
        System.out.println(j);
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partition_pt = partition(array, begin, end);
            System.out.println(Arrays.toString(array));
            quickSort(array, begin, partition_pt - 1);
            quickSort(array, partition_pt + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 72, 113, 11, 23,88,75,43,72};
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后的结果");
        System.out.println(Arrays.toString(array));
    }
}
