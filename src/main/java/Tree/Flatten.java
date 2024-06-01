package Tree;

import entity.ListNode;
import entity.TreeNode;

import java.awt.*;

/**
 * @program: leetcode
 * @description: 114
 * @author: Skyler
 * @create: 2024-03-23 12:24
 **/

public class Flatten {
    public void flatten(TreeNode root) {
        root = flat(root);
    }

    public TreeNode flat(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        root.right = left;
        root.left = null;
        while (left.right != null) left = left.right;
        left.right = right;
        return root;
    }
}
