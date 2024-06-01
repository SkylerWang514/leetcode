package listNode;

import entity.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 148
 * @author: Skyler
 * @create: 2024-03-21 21:02
 **/

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode();
        h.next = head;
        ListNode now = head;
        PriorityQueue<ListNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head.next != null){
            now = head;
            head = head.next;
            now.next = null;
            nodes.offer(now);
        }
        head = h;
        while (nodes.size() != 0){
            now = nodes.poll();
            head.next = now;
            head = head.next;
        }
        return h.next;
    }


}
