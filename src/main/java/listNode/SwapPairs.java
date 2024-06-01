package listNode;

import entity.ListNode;

/**
 * @program: leetcode
 * @description: 24
 * @author: Skyler
 * @create: 2024-03-18 18:42
 **/

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = new ListNode(0), pre, end, before, back;
        h.next = head;
        pre = head;
        end = pre.next;
        before = h;
        while (end != null && pre != null){
            if (pre.next == null) break;
            end = pre.next;
            back = end.next;
            pre.next = back;
            end.next = pre;
            before.next = end;
            before = pre;
            pre = pre.next;
        }
        return h.next;
    }
}
