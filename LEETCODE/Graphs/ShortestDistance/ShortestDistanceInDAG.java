package LEETCODE.Graphs.ShortestDistance;
import java.util.*;

public class ShortestDistanceInDAG {
    static class pair{
        int node ;
        int weight; 
        pair(int node, int weight){
            this.node  = node;
            this.weight = weight;
        }
    }
    private static void dfs(int nde , boolean[] vis, List<List<pair>> adj,Stack<)[
        vis[nde] = true;
        for(int )
    ]
    private static void shortestpathindag(int edges[][]){
        int V = 0;
        for (int[] edge : edges) {
            V = Math.max(V, Math.max(edge[0], edge[1]));
        }
        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new pair(v, w));
        }

        // now perform topo sort or dfs from connected components 
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs();
            }
        } 
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
    }
}
