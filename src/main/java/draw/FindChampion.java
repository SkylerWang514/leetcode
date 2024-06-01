package draw;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 2924
 * @author: Skyler
 * @create: 2024-04-13 11:52
 **/

public class FindChampion {
    public int findChampion(int n, int[][] edges) {
        int[][] paint = new int[n][n];
        for (int[] thisPath:
             edges) {
            paint[thisPath[1]][thisPath[0]] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < paint.length; j++) {
            int[] thisGroup = paint[j];
            int exist = 0;
            for (int value : thisGroup) {
                if (value > 0) {
                    exist = 1;
                    break;
                }
            }
            if (exist == 0) list.add(j);
        }
        if (list.size() > 1) return -1;
        else return list.get(0);
    }
}
