package Tree;

import entity.TreeNode;

/**
 * @program: leetcode
 * @description: 543
 * @author: Skyler
 * @create: 2024-03-15 21:44
 **/

public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        get1(root);
        return max;
    }
    public int get1(TreeNode root){
        if (root == null) return 0;
        int left = get1(root.left);
        int right = get1(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
