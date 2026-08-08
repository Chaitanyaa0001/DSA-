package LEETCODE.Graphs.ShortestDistance;

import java.util.*;

public class ShortestDinUndirectedGraph {
    static class pair {
        int node;
        int dis; 
        pair(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    private static  void shortestdistance(int edges[][]){
        int V = 0;
        for(int[] edge : edges){
             V = Math.max(V, Math.max(edge[0],edge[1]));          
        }
        V++;
        List<List<Integer>> adj = new ArrayList<>();

        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());

        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // now bfs  
        Queue<pair> q = new LinkedList<>();
        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int src = 0;
        distance[src] = 0;
        q.add(new pair(src, 0));

        while (!q.isEmpty()) {
            pair  curr= q.poll();
            int node = curr.node;
            int Prevdis = curr.dis;

            
            for(int nei : adj.get(node)){
                if(Prevdis + 1 < distance[nei]){
                    distance[nei] = Prevdis + 1;
                    q.offer(new pair(nei, Prevdis + 1)); 
                }
            }
            // other eg 
            // we can also store distance in my array 
            // for(int nei : adj.get(node)){
                // if(distance[node] + 1 < distance[nei]){
                    // distance[nei]  = distance[node] + 1;
                    // q.offer(nei)
                // }
            // }

        }

        
    }
    public static void main(String[] args) {
        int[][] edges = {
    {0, 1},
    {0, 3},
    {1, 2},
    {1, 3},
    {2, 6},
    {3, 4},
    {4, 5},
    {5, 6},
    {6, 7},
    {6, 8},
    {7, 8}
};
    }
}
