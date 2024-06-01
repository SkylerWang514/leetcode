package listNode;

import entity.ListNode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: leetcode
 * @description: 61
 * @author: Skyler
 * @create: 2024-03-07 13:52
 **/

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode begin = new ListNode();
        ListNode count = new ListNode();
        count = head;
        int length = 1;
        while (count.next != null){
            count = count.next;
            length++;
        }
        System.out.println(length);
        count.next = head;
        k = length % k;
        k = length - k;
        System.out.println(k);
        while (k != 1){
            head = head.next;
            k--;
        }
        begin = head;
        head = head.next;
        begin.next = null;
        return head;
    }

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(5);
        set.add(1);
        set.add(9);
        set.add(4);
        set.add(6);
        System.out.println(Arrays.toString(set.toArray()));
    }
}
