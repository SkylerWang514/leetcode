package matrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 994
 * @author: Skyler
 * @create: 2024-03-22 22:30
 **/

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int[] di = new int[]{-1, 1, 0, 0};
        int[] dj = new int[]{0, 0, -1, 1};
        Queue<int[]> badOrange = new ArrayDeque<>();
        int goodOrangeNum = 0;
        int step = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) goodOrangeNum++;
                if (grid[i][j] == 2) badOrange.add(new int[]{i, j});
            }
        }
        int[] now;
        int x, y;
        while (badOrange.size() != 0 && goodOrangeNum > 0){
            step++;
            int size = badOrange.size();
            for (int i = 0; i < size; i++) {
                now = badOrange.poll();
                for (int j = 0; j < 4; j++) {
                    x = now[0] + di[j];
                    y = now[1] + dj[j];
                    if (x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && grid[x][y] == 1){
                        grid[x][y] = 2;
                        badOrange.offer(new int[]{x, y});
                        goodOrangeNum--;
                    }
                }
            }
        }
        if (goodOrangeNum > 0) return -1;
        else return step;
    }
}
