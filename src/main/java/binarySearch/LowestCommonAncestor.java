package binarySearch;

import entity.TreeNode;

import java.util.*;

/**
 * @program: leetcode
 * @description: 236
 * @author: Skyler
 * @create: 2024-03-08 21:02
 **/

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && left != null) return root;
        if (left == null) return right;
        return left;
    }
}
