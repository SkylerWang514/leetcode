package listNode;

import entity.ListNode;

/**
 * @program: leetcode
 * @description: 23
 * @author: Skyler
 * @create: 2024-03-10 12:00
 **/

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode();
        node = mergeK(lists, 0, lists.length - 1);
        return node;
    }

    public ListNode mergeK(ListNode[] listNodes, int begin, int end){
        if (begin > end) return null;
        if (begin == end) return listNodes[begin];
        ListNode new1 = new ListNode();
        int mid = (begin + end) / 2;
        new1 = mergeTwo(mergeK(listNodes, begin, mid), mergeK(listNodes, mid + 1, end));
        return new1;
    }

    public ListNode mergeTwo(ListNode a, ListNode b){
        if (a == null) return b;
        if (b == null) return a;
        ListNode now = new ListNode(0);
        ListNode tail = new ListNode();
        tail = now;
        while (a != null && b != null){
            if (a.val > b.val){
                tail.next = b;
                b = b.next;
            }else{
                tail.next = a;
                a = a.next;
            }
        }
        if (a != null) tail.next = a;
        if (b != null) tail.next = b;
        return now.next;
    }
}
