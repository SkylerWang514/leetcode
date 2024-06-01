package Tree;

import entity.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 230
 * @author: Skyler
 * @create: 2024-03-22 23:14
 **/

public class KthSmallest {
    int num = 0;
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        kth(root, k);
        return val;
    }
    public void kth(TreeNode root, int k) {
        if (root == null) return;
        kth(root.left, k);
        num++;
        if (num == k)
            val = root.val;
        kth(root.right, k);
    }
}
