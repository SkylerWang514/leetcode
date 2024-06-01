package binarySearch;

import entity.TreeNode;

import java.util.*;

/**
 * @program: leetcode
 * @description: 199
 * @author: Skyler
 * @create: 2024-03-11 15:46
 **/

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count;
        while (!q.isEmpty()) {
            count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if (i == count - 1) ans.add(node.val);
            }
        }
        return ans;
    }
}
