package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: leetcode
 * @description: 56
 * @author: Skyler
 * @create: 2024-03-10 14:37
 **/
// 先排序再挨个merge，只需要考虑与上一个有没有区别就行
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ints = new ArrayList<>();
        for (int[] i:
             intervals) {
            if (ints.size() == 0 || i[0] > ints.get(ints.size() - 1)[1]){
                System.out.println("add:" + Arrays.toString(i));
                ints.add(i);
            }else{
                int[] ints1 = ints.get(ints.size() - 1);
                ints1[1] = Math.max(ints1[1], i[1]);
                ints.set(ints.size() - 1, ints1);
            }
        }
        return ints.toArray(new int[ints.size()][2]);
    }
}
