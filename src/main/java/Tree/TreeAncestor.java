package Tree;

/**
 * @program: leetcode
 * @description: 1483
 * @author: Skyler
 * @create: 2024-04-06 14:26
 **/

public class TreeAncestor {
    int[] tree;
    public TreeAncestor(int n, int[] parent) {
        tree = parent;
    }

    public int getKthAncestor(int node, int k) {
        int re = node;
        int i;
        for (i = 0; i < k; i++) {
            re = tree[re];
            if (re == -1) break;
        }
        return re;
    }
}
