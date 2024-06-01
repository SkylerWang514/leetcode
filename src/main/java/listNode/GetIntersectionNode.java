package listNode;

import entity.ListNode;

import java.awt.*;

/**
 * @program: leetcode
 * @description: 160
 * @author: Skyler
 * @create: 2024-03-11 14:58
 **/

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
