package LEETCODE.Graphs.traversalProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S6_DetectaCycle {
    static class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    private static  boolean bfs(int node , boolean vis[], List<List<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        vis[node] = true;

        while (!q.isEmpty()) {
            Pair curr  = q.poll();  //(0,-1)
            int Currnode = curr.node; // 0
            int parent = curr.parent; // -1

            for(int nei : adj.get(Currnode)){
                if(!vis[nei]){
                    q.add(new Pair(nei, Currnode));
                    vis[nei] = true;
                }else if( parent != nei){
                    return true;   
                }
            }
        }
        return false;
    }

    private static boolean detectacycle(int V, int[][] edges){
        // first convert edegs into adj list 
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

        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(bfs(i,vis,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][]edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int V = 4;  
        detectacycle(V, edges);
    }
}
