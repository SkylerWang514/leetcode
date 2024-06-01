package listNode;

import entity.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 25
 * @author: Skyler
 * @create: 2024-03-07 19:54
 **/

public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0), before, pre, back, end;
        hair.next = head;
        before = hair;
        pre = head;
        back = head;
        while (pre != null){
            for (int i = 0; i < k - 1; i++) {
                back = back.next;
                if (back == null) break;
            }
            if (back == null) break;
            System.out.println(pre.val);
            System.out.println(back.val);
            end = back.next;
            List<ListNode> list = reverse(pre, back);
            before.next = list.get(0);
            if (end == null) break;
            pre = end;
            back = pre;
            before = list.get(1);
        }
        return hair.next;
    }

    public static List<ListNode> reverse(ListNode pre, ListNode back){
        List<ListNode> listNodes = new ArrayList<>();
        ListNode newPre = pre.next, end = pre;
        while (pre != back){
            newPre = pre.next;
            pre.next = back.next;
            back.next = pre;
            pre = newPre;
        }
        listNodes.add(pre);
        listNodes.add(end);
        return listNodes;
    }

}
