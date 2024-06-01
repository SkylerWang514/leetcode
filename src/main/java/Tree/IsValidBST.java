package Tree;

import entity.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 98
 * @author: Skyler
 * @create: 2024-03-21 21:33
 **/

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode root, long min, long max) {
        if (root == null) return true;
        return isValidBST1(root.left, min, root.val) && isValidBST1(root.right, root.val, max) && root.val > min && root.val < max;
    }
}
