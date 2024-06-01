package sonArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 239
 * @author: Skyler
 * @create: 2024-03-17 15:49
 **/

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });
        int[] ans = new int[nums.length];
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        System.out.println(priorityQueue.peek()[0]);
        ans[0] = priorityQueue.peek()[1];
        for (int i = k; i < nums.length; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            if (priorityQueue.peek()[1] < i - k + 1) priorityQueue.poll();
            ans[i - k + 1] = priorityQueue.peek()[1];
        }
        return ans;
    }
}
