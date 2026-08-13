package LEETCODE.Graphs.ShortestDistance;

import java.util.*;

public class ShortestDistanceInDAG {

    static class pair {
        int node;
        int weight;

        pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static void dfs(int node, boolean[] vis, List<List<pair>> adj, Stack<Integer> stk) {

        vis[node] = true;

        for (pair nei : adj.get(node)) {
            int curr = nei.node;

            if (!vis[curr]) {
                dfs(curr, vis, adj, stk);
            }
        }

        stk.push(node);
    }

    private static void shortestpathindag(int[][] edges) {

        // Find number of vertices
        int V = 0;
        for (int[] edge : edges) {
            V = Math.max(V, Math.max(edge[0], edge[1]));
        }
        V++;

        // Build adjacency list
        List<List<pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new pair(v, w));
        }

        // Topological Sort
        boolean[] vis = new boolean[V];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, stk);
            }
        }

        // Shortest Distance
        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);

        int src = 6;
        dis[src] = 0;
        // O(n + m)  n = nodes m = edges
        while (!stk.isEmpty()) {

            int node = stk.pop();

            if (dis[node] != Integer.MAX_VALUE) {

                for (pair nei : adj.get(node)) {

                    int next = nei.node;
                    int wt = nei.weight;

                    if (dis[node] + wt < dis[next]) {
                        dis[next] = dis[node] + wt;
                    }
                }
            }
        }       

        System.out.println(Arrays.toString(dis));
    }

    public static void main(String[] args) {

        int[][] edges = {
                {6, 4, 2},
                {6, 5, 3},
                {5, 4, 1},
                {4, 0, 3},
                {4, 2, 1},
                {0, 1, 2},
                {1, 3, 1},
                {2, 3, 3}
        };

        shortestpathindag(edges);
    }
}