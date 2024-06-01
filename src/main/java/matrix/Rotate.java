package matrix;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 48
 * @author: Skyler
 * @create: 2024-03-27 16:04
 **/

public class Rotate {
    public void rotate(int[][] matrix) {
        swapUpDown(matrix);
        System.out.println(Arrays.deepToString(matrix));
        swapLine(matrix);
    }

    public void swapUpDown(int[][] matrix){
        int i = 0, j = matrix.length - 1;
        while (i < j - 1){
            for (int k = 0; k < matrix[0].length; k++)
                swap(matrix, i, k, j, k);
            i++;
            j--;
        }
    }

    public void swapLine(int[][] matrix){
        int j, left;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int L = 1; L < matrix.length - i - 1; L++) {
                j = i + L;
                System.out.println("i:" + i + "\tj:" + j);
                swap(matrix, i, j, j, i);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int x, int y){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}
