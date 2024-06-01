package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 54
 * @author: Skyler
 * @create: 2024-02-20 13:37
 **/

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integers = new ArrayList<>();
        int rowMaxIndex = matrix.length;
        int columnMaxIndex = matrix[0].length;
        System.out.println("rowMaxIndex: " + rowMaxIndex);
        System.out.println("columnMaxIndex: " + columnMaxIndex);
        int allNum = (rowMaxIndex) * (columnMaxIndex);
        int x = 0, y = 0;
        // 0: right; 1, down; 2, left; 3:up.
        int flag = 0;
        int beginColumn = -1;
        integers.add(matrix[x][y]);
        for (int i = 0; i < allNum - 1; i++) {
            System.out.println("rowMaxIndex: " + rowMaxIndex);
            System.out.println("columnMaxIndex: " + columnMaxIndex);
            if(x == y && flag == 0){
                rowMaxIndex -= 1;
                columnMaxIndex -= 1;
                System.out.println("rowMaxIndex: " + rowMaxIndex);
                System.out.println("columnMaxIndex: " + columnMaxIndex);
                beginColumn += 1;
            }
            // change direction
            if (flag == 0 && y == columnMaxIndex) flag = 1;
            else if (flag == 1 && x == rowMaxIndex) flag = 2;
            else if (flag == 2 && y == beginColumn) flag = 3;
            else if (flag == 3 && x == y + 1)
                flag = 0;
            System.out.println("flag: " + flag);
            switch (flag){
                case 0:
                    y += 1;
                    break;
                case 1:
                    x += 1;
                    break;
                case 2:
                    y -= 1;
                    break;
                case 3:
                    x -= 1;
                    break;
            }
            System.out.println("x:" + x);
            System.out.println("y:" + y);
            integers.add(matrix[x][y]);
        }
        return integers;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30}}));
    }
}
