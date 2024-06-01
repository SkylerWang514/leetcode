package listNode;

import entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 82
 * @author: Skyler
 * @create: 2024-03-15 11:52
 **/

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode point = new ListNode();
        point = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (point != null){
            if (map.containsKey(point.val)) map.computeIfPresent(point.val, (k, v) -> v = v + 1);
            else map.put(point.val, 1);
            point = point.next;
        }
        for (Map.Entry<Integer, Integer> entry:
             map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        ListNode newBegin = new ListNode(0);
        ListNode newEnd = newBegin;
        ListNode newOne = new ListNode();
        while (head != null){
            System.out.println(head.val);
            if (head.val != newEnd.val && map.get(head.val) == 1){
                System.out.println("add");
                newEnd.next = head;
                newEnd = newEnd.next;
            }
            if (head.next == null) break;
            newOne = head;
            head = head.next;
            newOne.next = null;
        }
        return newBegin.next;
    }
}
