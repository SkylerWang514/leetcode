package listNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 138
 * @author: Skyler
 * @create: 2024-03-18 19:35
 **/

public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    Map<Node, Node> nodeNodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (nodeNodeMap.containsKey(head)) return nodeNodeMap.get(head);
        else {
            Node node = new Node(head.val);
            nodeNodeMap.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        }
    }
}
