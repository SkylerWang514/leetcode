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
    public TreeNode flat(TreeNode root) {
        return flatten(root);
    }

    public static TreeNode flatten(TreeNode root){
        if (root.left == null && root.right == null) return root;
        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);
        root.left = null;
        root.right = left;
        TreeNode now = left;
        while (now.right != null) now = now.right;
        now.right = right;
        return root;
    }
}
