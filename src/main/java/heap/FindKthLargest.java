package heap;

import Array.FastSort;
import io.swagger.models.auth.In;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 215
 * @author: Skyler
 * @create: 2024-03-07 15:50
 **/

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        int now;
        for (int i = k; i < nums.length; i++) {
            now = queue.peek();
            if (nums[i] > now){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
    public static int findKthLargest1(int[] nums, int k) {
//        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n:
             nums) {
            if (map.containsKey(n)) map.computeIfPresent(n, (s, v) -> v = v + 1);
            else map.put(n, 1);
        }
        System.out.println(Arrays.toString(Arrays.stream(nums).boxed().sorted((o1, o2) -> o2 - o1).toArray()));
        int count = k;
        for (Map.Entry<Integer, Integer> set: map.entrySet()){
            count = count - set.getValue();
            if (count <= 0) return set.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
