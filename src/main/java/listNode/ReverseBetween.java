package listNode;

import entity.ListNode;

/**
 * @program: leetcode
 * @description: 92
 * @author: Skyler
 * @create: 2024-03-09 21:45
 **/

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p = new ListNode();
        p.next = head;
        if (left == right) return head;
        ListNode nowBegin = head;
        ListNode nowEnd = head;
        ListNode pre, last;
        if (left == 1){
            pre = p;
        }else {
            for (int i = 0; i < left - 2; i++) {
                nowBegin = nowBegin.next;
            }
            pre = nowBegin;
            nowBegin = nowBegin.next;
        }
        for (int i = 0; i < right - 1; i++) {
            nowEnd = nowEnd.next;
        }
        ListNode final1 = nowEnd.next;
        last = nowEnd.next;
        ListNode node;
        for (int i = left; i < right; i++) {
            node = nowBegin;
            nowBegin = nowBegin.next;
            node.next = last;
            last = node;
            nowEnd.next = last;
        }
        pre.next = nowBegin;
        return head;
    }
}
