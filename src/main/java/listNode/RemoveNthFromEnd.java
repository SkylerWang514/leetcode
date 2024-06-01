package listNode;

import entity.ListNode;

/**
 * @program: leetcode
 * @description: 19
 * @author: Skyler
 * @create: 2024-03-17 17:15
 **/

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode begin = h, end = head;
        for (int i = 0; i < n - 1; i++) {
            end = end.next;
        }
        while (end != null && end.next != null){
            begin = begin.next;
            end = end.next;
        }
        begin.next = begin.next.next;
        return h.next;
    }
}
