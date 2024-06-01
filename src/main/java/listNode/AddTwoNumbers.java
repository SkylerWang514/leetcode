package listNode;

import entity.ListNode;

/**
 * @program: leetcode
 * @description: 2
 * @author: Skyler
 * @create: 2024-02-11 10:07
 **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int result = l1Val + l2Val + carry;
            carry = result / 10;
            ListNode newNode = new ListNode(result % 10);
            if (head == null){
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) tail.next = new ListNode(carry);
        return head;
    }

    public static void listPlus1(ListNode listNode){
        if (listNode.val != 9) listNode.val += 1;
        else {
            listNode.val = 0;
            if (listNode.next == null){
                listNode.next = new ListNode(0);
            }
            listPlus1(listNode.next);
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        listPlus1(listNode);
        while (true){
            System.out.println(listNode.val);
            if (listNode.next != null)
                listNode = listNode.next;
            else break;
        }
    }
}
