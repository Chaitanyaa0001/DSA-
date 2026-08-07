package LEETCODE.Graphs.traversalProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S2_ConnectedComponents {

    // BFS to visit all nodes in one connected component
    private static void bfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        // Start BFS from the given node
        q.offer(node);
        vis[node] = true;
        while (!q.isEmpty()) {
            int nde = q.poll();
            // Traverse all neighbours of current node
            for (int nei : adj.get(nde)) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        // ---------------------------------------------------
        // Step 1 : Create Adjacency List
        // ---------------------------------------------------
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Since graph is undirected, add both directions
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // ---------------------------------------------------
        // Step 2 : BFS on every unvisited node
        // Every new BFS = One Connected Component
        // ---------------------------------------------------
        boolean vis[] = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            // New component found
            if (!vis[i]) {
                count++;
                // Visit the complete component
                bfs(i, vis, adj);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // Example:
        //
        // 0 ----- 1 ----- 2
        //
        // 3 ----- 4
        //
        // Connected Components:
        // {0,1,2}
        // {3,4}
        //
        // Answer = 2
        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(0, 1));
        edges.add(List.of(1, 2));
        edges.add(List.of(3, 4));
        int ans = findNumberOfComponent(V, edges);
        System.out.println("Number of Connected Components = " + ans);
    }
}