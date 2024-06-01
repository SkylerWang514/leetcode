package Tree;

import entity.TreeNode;

/**
 * @program: leetcode
 * @description: 124
 * @author: Skyler
 * @create: 2024-03-10 15:26
 **/

public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        return max;
    }
    public int maxPathSum1(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPathSum1(root.left), 0);
        int right = Math.max(maxPathSum1(root.right), 0);
        int now_value = left + right + root.val;
        max = Math.max(now_value, max);
        return Math.max(left, right) + root.val;
    }
}
