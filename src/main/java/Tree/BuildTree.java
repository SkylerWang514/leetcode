package Tree;

import entity.TreeNode;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 104
 * @author: Skyler
 * @create: 2024-02-22 22:20
 **/

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        System.out.println("preOrder:" + Arrays.toString(preorder));
        System.out.println("inOrder:" + Arrays.toString(inorder));
        if (preorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == node.val) break;
        }
        System.out.println("i:" + i);
        System.out.println("preorder[0]:" + preorder[0]);
        if (i == 0){
            node.left = null;
            if (preorder.length == 1 || inorder.length == 1)
                node.right = null;
            else {
                int[] newPre = new int[preorder.length - 1];
                System.arraycopy(preorder, 1, newPre, 0, preorder.length - 1);
                int[] newInorder = new int[inorder.length - 1];
                System.arraycopy(inorder, 1, newInorder, 0, preorder.length - 1);
                node.right = buildTree(newPre, newInorder);
            }
        }else if (i == inorder.length - 1){
            node.right = null;
            int[] newPre = new int[preorder.length - 1];
            System.arraycopy(preorder, 1, newPre, 0, preorder.length - 1);
            int[] newInorder = new int[inorder.length - 1];
            System.arraycopy(inorder, 0, newInorder, 0, preorder.length - 1);
            node.left = buildTree(newPre, newInorder);
        }else {
            //left
            int[] leftInorder = new int[i];
            System.arraycopy(inorder, 0, leftInorder, 0, i);
            int[] leftPre = new int[i];
            System.arraycopy(preorder, 1, leftPre, 0, i);
            node.left = buildTree(leftPre, leftInorder);

            //get preOrder[i] in
            //right
            int[] rightInorder = new int[inorder.length - i - 1];
            System.arraycopy(inorder, i + 1, rightInorder, 0, inorder.length - i - 1);
            int[] rightPre = new int[preorder.length - i - 1];
            System.arraycopy(preorder, i + 1, rightPre, 0, preorder.length - i - 1);
            node.right = buildTree(rightPre, rightInorder);
        }
        return node;
    }

}
