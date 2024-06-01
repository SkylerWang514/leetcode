package Calculation;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 141
 * @author: Skyler
 * @create: 2024-02-02 22:44
 **/

public class ListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<ListNode>();
        while (head != null){
            if (!nodes.contains(head)){
                nodes.add(head);
            }else return true;
            head = head.next;
        }
        return false;
    }

}
