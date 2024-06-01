package heap;

import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 295
 * @author: Skyler
 * @create: 2024-03-23 16:49
 **/

public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> big;
    public MedianFinder() {
        // 小顶堆，存大数据
        small = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        // 大顶堆，存小数据
        big = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    }

    public void addNum(int num) {
        if (small.size() > big.size()){
            small.offer(num);
            big.offer(small.poll());
        }else {
            big.offer(num);
            small.offer(big.poll());
        }
    }

    public double findMedian() {
        if (small.size() > big.size())
            return small.peek();
        else if (big.size() > small.size())
            return big.peek();
        return (small.peek() + big.peek()) / 2.0;
    }
}
