package Tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 437
 * @author: Skyler
 * @create: 2024-03-23 12:56
 **/

public class PathSum {
    public void flatten(TreeNode root) {
        root = flat(root);
    }

    public TreeNode flat(TreeNode root) {
        if (root == null) return null;
        if (root.left == null){
            root.right = flat(root.right);
            return root;
        }
        System.out.println("root:" + root.val);
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        System.out.println("left:" + (left == null ? "null" : left.val));
        System.out.println("right:" + (right == null ? "null" : right.val));
        root.left = null;
        root.right = left;
        while (left.right != null) left = left.right;
        left.right = right;
        return root;
    }
}
