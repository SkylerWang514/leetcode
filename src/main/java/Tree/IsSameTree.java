package Tree;

import entity.TreeNode;
import io.swagger.models.auth.In;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 100
 * @author: Skyler
 * @create: 2024-02-11 21:20
 **/

public class IsSameTree {
    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null){
            ArrayList<Integer> integersP = new ArrayList<>();
            ArrayList<Integer> integersQ = new ArrayList<>();
            integersP = treeToArray(p);
            integersQ = treeToArray(q);
            System.out.println(Arrays.toString(integersP.toArray()));
            System.out.println(Arrays.toString(integersQ.toArray()));
            if (integersP.size() != integersQ.size()) return false;
            for (int i = 0; i < integersP.size(); i++) {
                if (!integersP.get(i).equals(integersQ.get(i))) return false;
            }
            return true;
        }else return false;
    }

    public static ArrayList<Integer> treeToArray(TreeNode node){
        ArrayList<Integer> integers = new ArrayList<>();
        if (node.right == null && node.left == null){
            integers.add(node.val);
            return integers;
        }else if (node.left == null){
            integers.add(Integer.MIN_VALUE);
            integers = treeToArray(node.right);
            integers.add(node.val);
            return integers;
        }else if (node.right == null){
            integers = treeToArray(node.left);
            integers.add(Integer.MIN_VALUE);
            integers.add(node.val);
            return integers;
        }else {
            integers.addAll(treeToArray(node.left));
            integers.addAll(treeToArray(node.right));
            integers.add(node.val);
            return integers;
        }

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
