package listNode;

import entity.ListNode;

/**
 * @program: leetcode
 * @description: 234
 * @author: Skyler
 * @create: 2024-03-17 20:04
 **/

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        StringBuilder stringBuffer = new StringBuilder();
        while (head != null){
            stringBuffer.append(head.val);
            head = head.next;
        }
        return stringBuffer.toString().equals(stringBuffer.reverse().toString());
    }
}
