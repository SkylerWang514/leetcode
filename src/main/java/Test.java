import entity.ListNode;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: Skyler
 * @create: 2024-03-13 18:56
 **/

public class Test {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre, back, before, end;
        pre = hair;
        before = head;
        end = head;
        while (before != null){
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) return hair;
            }
            back = end.next;
            List<ListNode> re = reverse(before, end);
            pre.next = re.get(0);
            pre = re.get(1);
            pre.next = back;
            before = pre.next;
            end = pre.next;
        }
        return hair;
    }

    public List<ListNode> reverse(ListNode before, ListNode end){
        ListNode tail = end.next, last = before, head = before;
        while (before != end){
            before = before.next;
            head.next = tail;
            end.next = head;
            tail = head;
            head = before;
        }
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(end);
        listNodes.add(last);
        return listNodes;
    }
}
