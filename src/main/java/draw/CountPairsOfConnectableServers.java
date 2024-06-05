package draw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 3067
 * @author: Skyler
 * @create: 2024-06-03 17:56
 **/
public class CountPairsOfConnectableServers {
//    private static int[][] All_Edges;
//    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
//        All_Edges = edges;
//
//        //Get number of points
//        int point_num = 0;
//        for (int i = 0; i < edges.length; i++) {
//            point_num = Math.max(point_num, Math.max(edges[i][0], edges[i][1]));
//        }
//
//        int[] result = new int[point_num];
//        for (int i = 0; i < point_num; i++) {
//            ArrayList<ArrayList<Integer>> far = new ArrayList<>();
//            for (int j = 0; j < edges.length; j++) {
//                if (edges[j][0] == i || edges[j][1] == i) {
//                    addNewEdge(far, i, j);
//                }
//            }
//        }
//        return result;
//    }
//
//    private void addNewEdge(ArrayList<ArrayList<Integer>> far, int point_no, int edge_no) {
//        ArrayList<Integer> affectPoint = new ArrayList<>();
//
//    }
public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
    //树的节点数永远等于边数+1
    int n = edges.length + 1;
    //画一张图，第n个数组里包含了所有他链接的边int[2]{另外一端的点，边长}
    List<int[]>[] graph = new ArrayList[n];
    Arrays.setAll(graph, i -> new ArrayList<>());
    for (int[] e : edges) {
        int u = e[0];
        int v = e[1];
        int w = e[2];
        graph[u].add(new int[]{v, w});
        graph[v].add(new int[]{u, w});
    }

    int[] res = new int[n];
    //遍历每个点
    for (int i = 0; i < n; i++) {
        int pre = 0;
        //遍历每条边
        for (int[] e : graph[i]) {
            int cnt = dfs(e[0], i, e[1] % signalSpeed, signalSpeed, graph);
            res[i] += pre * cnt;
            pre += cnt;
        }
    }
    return res;
}


    private int dfs(int p, int root, int curr, int signalSpeed, List<int[]>[] graph) {
        int res = 0;

        if (curr == 0) {res++;}
        for (int[] e : graph[root]) {
            int v = e[0];
            int cost = e[1];
            if (v != root){
                res += dfs(v, p, (curr + cost) % signalSpeed, signalSpeed, graph);
            }
        }

        return res;
    }

}
