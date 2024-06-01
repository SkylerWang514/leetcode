package binarySearch;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 102
 * @author: Skyler
 * @create: 2024-03-07 22:45
 **/

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> nodes = new LinkedList<>();
        int size = 0;
        nodes.offer(root);
        while (!nodes.isEmpty()){
            size = nodes.size();
            List<Integer> small = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode a = nodes.poll();
                if (a.left != null) nodes.offer(a.left);
                if (a.right != null) nodes.offer(a.right);
                small.add(a.val);
            }
            lists.add(small);
        }
        return lists;
    }

}
