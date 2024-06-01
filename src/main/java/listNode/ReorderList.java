package listNode;

import entity.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: leetcode
 * @description: 143
 * @author: Skyler
 * @create: 2024-03-10 13:28
 **/

public class ReorderList {
    public void reorderList(ListNode head) {
        Deque<ListNode> nodes = new LinkedList<>();
        ListNode add = new ListNode();
        ListNode remark = new ListNode();
        add = head;
        while (add != null){
            nodes.offerLast(add);
            remark = add;
            add = add.next;
            remark.next = null;
        }
        ListNode p = new ListNode();
        ListNode move = new ListNode();
        move = p;
        ListNode first = new ListNode();
        ListNode end = new ListNode();
        while (!nodes.isEmpty()){
            first = nodes.pollFirst();
            move.next = first;
            first.next = null;
            move = move.next;
            if (nodes.isEmpty()) break;
            end = nodes.pollLast();
            move.next = end;
            end.next = null;
            move = move.next;
        }
        head = p.next;
    }
}
