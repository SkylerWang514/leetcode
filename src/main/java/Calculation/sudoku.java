package Calculation;

/**
 * @program: leetcode
 * @description: 36
 * @author: Skyler
 * @create: 2024-02-02 20:11
 **/

public class sudoku {
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] grid = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (Character.isLetterOrDigit(c)){
                    int loc = (int)c - 48;
                    row[i][loc]++;
                    column[loc][i]++;
                    grid[i / 3][j / 3][loc]++;
                    if (row[i][loc] > 1 || column[loc][i] > 1 || grid[i / 3][j / 3][loc] > 1)
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean isRowValid(char[][] board){
        for (int i = 0; i < 9; i++) {
            StringBuilder stringBuffer = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < stringBuffer.length(); k++) {
                    if (Character.isLetterOrDigit(board[i][j])){
                        if ((int)stringBuffer.charAt(k) == (int)board[i][j])
                            return false;
                        else stringBuffer.append(board[i][j]);
                    }
                }
                if (Character.isLetterOrDigit(board[i][j])) stringBuffer.append(board[i][j]);
            }
        }
        return true;
    }

    public static boolean isColumnValid(char[][] board){
        for (int j = 0; j < 9; j++) {
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int k = 0; k < stringBuffer.length(); k++) {
                    if (Character.isLetterOrDigit(board[i][j])){
                        if ((int)stringBuffer.charAt(k) == (int)board[i][j])
                            return false;
                        else stringBuffer.append(board[i][j]);
                    }
                }
                if (Character.isLetterOrDigit(board[i][j])) stringBuffer.append(board[i][j]);
            }
        }
        return true;
    }

    public static boolean is9Valid(char[][] board){
        for (int j = 0; j < 9; j++) {
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int k = 0; k < stringBuffer.length(); k++) {
                    if (Character.isLetterOrDigit(board[i][j])){
                        if ((int)stringBuffer.charAt(k) == (int)board[i][j])
                            return false;
                        else stringBuffer.append(board[i][j]);
                    }
                }
                if (Character.isLetterOrDigit(board[i][j])) stringBuffer.append(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'5' - '0' - 1);
        System.out.println((int)'6');
        System.out.println((int)'7');
    }
}
