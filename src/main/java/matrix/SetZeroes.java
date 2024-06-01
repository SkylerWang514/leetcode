package matrix;

/**
 * @program: leetcode
 * @description: 73
 * @author: Skyler
 * @create: 2024-03-15 22:51
 **/

public class SetZeroes {
    int row;
    int column;
    int[][] flagMatrix;
    public void setZeroes(int[][] matrix) {
        this.row = matrix.length;
        this.column = matrix[0].length;
        this.flagMatrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0 && flagMatrix[i][j] == 0){
                    setZero(matrix, i, j);
                }
            }
        }
    }
    public void setZero(int[][] nums, int i, int j){
        for (int k = 0; k < nums[0].length; k++) {
            if (nums[i][k] != 0)
                flagMatrix[i][k] = 1;
            nums[i][k] = 0;
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k][j] != 0)
                flagMatrix[k][j] = 1;
            nums[k][j] = 0;
        }
    }
}
