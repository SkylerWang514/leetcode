package Tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 106
 * @author: Skyler
 * @create: 2024-02-28 13:28
 **/

public class BuildTree2 {
    // 构造中序遍历的map
    static Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode node = new TreeNode();
        node = build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return node;
    }
    public static TreeNode build(int[] inorder, int[] postorder, int inorderBegin, int inorderEnd, int postOrderBegin, int postOrderEnd){
        if (inorderBegin == inorderEnd || postOrderBegin == postOrderEnd) return new TreeNode(inorder[inorderBegin]);
        if (inorderBegin > inorderEnd || postOrderBegin > postOrderEnd) return null;
        int root = postorder[postOrderEnd];
        System.out.println("root:" + root);
        System.out.println("inorderBegin:" + inorderBegin);
        System.out.println("inorderEnd:" + inorderEnd);
        System.out.println("postOrderBegin:" + postOrderBegin);
        System.out.println("postOrderEnd:" + postOrderEnd);
        int positionInInorder = inorderMap.get(root);

        int leftEnd = positionInInorder > 0 ? positionInInorder - 1 : -1;
        int leftLength = leftEnd > inorderBegin ? leftEnd - inorderBegin + 1 : 0;

        TreeNode node = new TreeNode(root);
        node.left = build(inorder, postorder, inorderBegin, inorderBegin + leftLength, postOrderBegin, postOrderBegin + leftLength);
        node.right = build(inorder, postorder, positionInInorder + 1, inorderEnd, postOrderBegin + leftLength + 1, postOrderEnd - 1);
        return node;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
