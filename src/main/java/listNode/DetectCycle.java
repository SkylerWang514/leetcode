package listNode;

import entity.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 142
 * @author: Skyler
 * @create: 2024-03-10 14:07
 **/

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode a = new ListNode();
        a = head;
        while (a != null){
            if (set.contains(a)) return a;
            else {
                set.add(a);
                a = a.next;
            }
        }
        return null;
    }
}
