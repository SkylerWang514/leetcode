package back;

/**
 * @program: leetcode
 * @description: 79
 * @author: Skyler
 * @create: 2024-03-24 16:51
 **/

public class Exist {
    boolean re = false;
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        if (board.length * board[0].length < word.length()) return false;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                exist1(board, wordArray, i, j, 0);
            }
        }
        return re;
    }
    public void exist1(char[][] board, char[] wordArray, int i, int j, int length) {
        if (length == wordArray.length){
            re = true;
            return;
        }
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || used[i][j])
            return;
        if (board[i][j] == wordArray[length]){
            System.out.println("i" + i);
            System.out.println("j" + j);
            used[i][j] = true;
            exist1(board, wordArray, i - 1, j, length + 1);
            exist1(board, wordArray, i + 1, j, length + 1);
            exist1(board, wordArray, i, j - 1, length + 1);
            exist1(board, wordArray, i, j + 1, length + 1);
            used[i][j] = false;
        }
    }
}
