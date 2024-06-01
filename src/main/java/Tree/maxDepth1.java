package Tree;

import entity.Node;

/**
 * @program: leetcode
 * @description: 559
 * @author: Skyler
 * @create: 2024-03-01 15:33
 **/

public class maxDepth1 {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if(root.children.size() == 0) return 1;
        int[] length = new int[root.children.size()];
        for(int i = 0 ; i < root.children.size(); i++){
            length[i] = maxDepth(root.children.get(i));
        }
        int max = 0;
        for(int i = 0 ; i < root.children.size(); i++){
            max = Math.max(max, length[i]);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        String a = "aa";
        String b = "aa";
        System.out.println(a);
        System.out.println(b);
        b = "bb";
        System.out.println(a);
        System.out.println(b);
    }
}
