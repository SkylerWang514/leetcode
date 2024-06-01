package Tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 94
 * @author: Skyler
 * @create: 2024-03-11 14:19
 **/

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left == null && root.right == null){
            list.add(root.val);
        }else if (root.left == null){
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
        }else if (root.right == null){
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
        }else {
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }
}
