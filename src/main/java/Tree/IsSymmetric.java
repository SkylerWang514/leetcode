package Tree;

import entity.TreeNode;

import java.util.*;

/**
 * @program: leetcode
 * @description: 101
 * @author: Skyler
 * @create: 2024-02-22 18:25
 **/

public class IsSymmetric {
//    public static TreeNode reverse(TreeNode root){
//        if (root == null) return root;
//        TreeNode left = reverse(root.left);
//        root.left = reverse(root.right);
//        root.right = left;
//        return root;
//    }
//
//    public List<Integer> presentTree(TreeNode root){
//        List<Integer> integers = new ArrayList<>();
//        if (root == null){
//            integers.add(101);
//            return integers;
//        }else {
//            integers.add(root.val);
//            if (root.left != null){
//                List<Integer> integersLeft = new ArrayList<>();
//                integersLeft = presentTree(root.left);
//                integers.addAll(integersLeft);
//            }
//            if (root.right != null){
//                List<Integer> integersRight = new ArrayList<>();
//                integersRight = presentTree(root.right);
//                integers.addAll(integersRight);
//            }
//        }
//        return integers;
//    }
//
//    public boolean isSymmetric(TreeNode root) {
//        TreeNode newNode = new TreeNode(root.val, root.left, root.right);
//        TreeNode reverse = reverse(root);
//        List<Integer> integersRoot = presentTree(newNode);
//        List<Integer> integersReverse = presentTree(reverse);
//        System.out.println(Arrays.toString(integersReverse.toArray()));
//        System.out.println(Arrays.toString(integersRoot.toArray()));
//        return integersReverse.equals(integersRoot);
//    }

    public boolean isSymmetric(TreeNode root) {
        return compareTwo(root, root);
    }

//    public static boolean compareTwo(TreeNode left, TreeNode right){
//        if (left == null && right == null) return true;
//        if (left == null || right == null) return false;
//        System.out.println("left:" + left.val);
//        System.out.println("right:" + right.val);
//        int leftState = getCurrentState(left);
//        int rightState = getCurrentState(right);
//        System.out.println("left State:" + leftState);
//        System.out.println("right State:" + rightState);
//        if (leftState == 0 && rightState == 0) return left.val == right.val;
//        if (leftState == 1 && rightState == 2) return compareTwo(left.left, right.right) && (left.val == right.val);
//        if (leftState == 2 && rightState == 1) return compareTwo(left.right, right.left) && (left.val == right.val);
//        if (leftState == 3 && rightState == 3)
//            return compareTwo(left.right, right.left) && compareTwo(left.left, right.right) && (left.val == right.val);
//        return false;
//    }

    public static boolean compareTwoWithQueue(TreeNode left, TreeNode right){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()){
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();
            if (u == null && v == null) continue;
            if (u == null || v == null || u.val != v.val) return false;

            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }

    public static boolean compareTwo(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return compareTwo(left.right, right.left) && compareTwo(left.left, right.right) && (left.val == right.val);
    }

    public static int getCurrentState(TreeNode root){
        if (root.left == null && root.right == null) return 0;
        if (root.left == null) return 1;
        if (root.right == null) return 2;
        return 3;
    }
}
