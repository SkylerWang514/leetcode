package heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 347
 * @author: Skyler
 * @create: 2024-03-16 16:42
 **/

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:
             nums) {
            if (map.containsKey(num)) map.computeIfPresent(num, (key, value) -> value = value + 1);
            else map.put(num, 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> mapSet:
             map.entrySet()) {
            int[] newInt = new int[2];
            newInt[0] = mapSet.getKey();
            newInt[1] = mapSet.getValue();
            priorityQueue.offer(newInt);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }
}
