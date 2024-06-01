package listNode;

import entity.ListNode;

import java.awt.*;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 206
 * @author: Skyler
 * @create: 2024-03-07 16:44
 **/

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode next = new ListNode();
        ListNode now = new ListNode();
        if (head.next == null) return head;
        next = head.next;
        head.next = null;
        while (next.next != null){
            now = next;
            next = next.next;
            now.next = head;
            head = now;
        }
        next.next = head;
        return next;
    }
    public ListNode reverseList1(ListNode head) {
        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode a = new ListNode();
        while (head != null){
            listNodeStack.push(head);
            a = head;
            head = head.next;
            a.next = null;
        }
        ListNode newHead = new ListNode();
        ListNode new1 = new ListNode();
        new1 = newHead;
        while (!listNodeStack.empty()){
            head = listNodeStack.pop();
            newHead.next = head;
            newHead = newHead.next;
        }
        return new1.next;
    }

    public static void main(String[] args) {
        Integer a=2;
        int b = 2;
        Integer c=new Integer(2);
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a.equals(c));
    }
}
