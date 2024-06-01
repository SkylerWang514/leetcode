package matrix;

/**
 * @program: leetcode
 * @description: 200
 * @author: Skyler
 * @create: 2024-03-09 20:44
 **/

public class NumIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (judge(grid, i, j) > 0) num++;
            }
        }
        return num;
    }

    public int judge(char[][] grid, int r, int c){
        if (!ifOut(grid, r, c)) return 0;
        if (grid[r][c] == '2' || grid[r][c] == '0') return 0;
        grid[r][c] = '2';
        return 1 + judge(grid, r + 1, c) + judge(grid, r - 1, c) + judge(grid, r, c+ 1) + judge(grid, r, c - 1);
    }

    public boolean ifOut(char[][] grid, int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
