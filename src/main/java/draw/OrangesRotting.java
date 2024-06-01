package draw;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: leetcode
 * @description: 994
 * @author: Skyler
 * @create: 2024-04-05 22:00
 **/

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int goodOrange = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    goodOrange++;
                }else if (grid[i][j] == 2){
                    deque.add(new int[]{i, j});
                }
            }
        }
        int patch = 0;
        while (goodOrange > 0 && !deque.isEmpty()){
            for (int i = 0; i < deque.size(); i++) {
                int[] goodOne = deque.poll();
                if (goodOne[0] - 1 >= 0 && goodOne[1] - 1 >= 0) {
                    if (grid[goodOne[0] - 1][goodOne[1] - 1] == 1){
                        grid[goodOne[0] - 1][goodOne[1] - 1] = 2;
                        goodOrange--;
                        deque.add(new int[]{goodOne[0] - 1, goodOne[1] - 1});
                    }
                }
                if (goodOne[0] + 1 < grid.length && goodOne[1] + 1 < grid.length) {
                    if (grid[goodOne[0] + 1][goodOne[1] + 1] == 1){
                        grid[goodOne[0] + 1][goodOne[1] + 1] = 2;
                        goodOrange--;
                        deque.add(new int[]{goodOne[0] + 1, goodOne[1] + 1});
                    }
                }
                if (goodOne[0] - 1 >= 0 && goodOne[1] + 1 < grid.length) {
                    if (grid[goodOne[0] - 1][goodOne[1] + 1] == 1){
                        grid[goodOne[0] - 1][goodOne[1] + 1] = 2;
                        goodOrange--;
                        deque.add(new int[]{goodOne[0] - 1, goodOne[1] + 1});
                    }
                }
                if (goodOne[0] + 1 < grid.length && goodOne[1] - 1 >= 0) {
                    if (grid[goodOne[0] + 1][goodOne[1] - 1] == 1){
                        grid[goodOne[0] + 1][goodOne[1] - 1] = 2;
                        goodOrange--;
                        deque.add(new int[]{goodOne[0] + 1, goodOne[1] - 1});
                    }
                }
            }
            patch++;
        }
        if (goodOrange != 0) return -1;
        else return patch;
    }
}
