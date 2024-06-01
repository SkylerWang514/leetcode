package Tree;

import entity.TreeNode;

/**
 * @program: leetcode
 * @description: 104
 * @author: Skyler
 * @create: 2024-02-08 10:42
 **/

public class maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return currentDepth(root);
    }

    public static int currentDepth(TreeNode root){
        int depth = 0;
        if (root.left != null && root.right != null){
            depth = Math.max(currentDepth(root.left), currentDepth(root.right)) + 1;
        }else if (root.left == null && root.right != null) {
            depth = currentDepth(root.right) + 1;
        }else if (root.left != null && root.right == null){
            depth = currentDepth(root.left) + 1;
        }else depth = 1;
        return depth;
    }

}
