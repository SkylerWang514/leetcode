package draw;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description: 2192
 * @author: Skyler
 * @create: 2024-04-04 11:27
 **/

public class GetAncestors {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] sons = new ArrayList[n];
        Arrays.setAll(sons, i -> new ArrayList<>());
        for (int[] edge:
             edges) {
            sons[edge[0]].add(edge[1]);
        }

        List<Integer>[] result = new ArrayList[n];
        Arrays.setAll(result, i -> new ArrayList<>());
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, i, vis, sons, result);
        }
        return Arrays.asList(result);
    }

    public void dfs(int now, int ancestor, int[] vis, List<Integer>[] sons, List<Integer>[] result){
        vis[now] = ancestor;
        for (int son:
             sons[now]) {
            if (vis[son] != ancestor){
                result[son].add(ancestor);
                dfs(son, ancestor, vis, sons, result);
            }
        }
    }

}
