package LEETCODE.Graphs.traversals;

import java.util.*;

public class breadthFirstSearch {

    // Returns BFS Traversal starting from node 0
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Visited array
        boolean[] vis = new boolean[V];

        // Stores final BFS order
        ArrayList<Integer> ans = new ArrayList<>();

        // Start from node 0
        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {

            // Remove front node
            int node = q.poll();

            // Visit it
            ans.add(node);

            // Traverse all neighbours
            for (int neighbour : adj.get(node)) {

                // If not visited
                if (!vis[neighbour]) {

                    vis[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        /*
              0
           /  |  \
          2   3   1
          |
          4
        */

        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);

        adj.get(1).add(0);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(0);

        adj.get(4).add(2);

        ArrayList<Integer> bfsTraversal = bfs(adj);

        System.out.println(bfsTraversal);
    }
}