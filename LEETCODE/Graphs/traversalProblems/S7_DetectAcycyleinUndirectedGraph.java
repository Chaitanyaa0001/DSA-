package LEETCODE.Graphs.traversalProblems;

import java.util.ArrayList;
import java.util.List;

public class S7_DetectAcycyleinUndirectedGraph {
   
   
    private boolean dfs(int node,int parent ,boolean vis[], List<List<Integer>> adj){
        vis[node] = true;
        
        for(int nei : adj.get(node)){
            if(!vis[nei]){
               if(dfs(nei,node,vis,adj)){
                   return true;
                }
            }else if(parent != nei){
                return true;
            }
        }
        return false;
        
    }
    public boolean isCyclic(int V, int[][] edges) {
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
        
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i,-1, vis,adj)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
