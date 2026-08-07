package LEETCODE.Graphs.topoSort_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S2_FindEventualStatesDFS {
    List<Integer> ans;
    private boolean dfs(int node,int graph[][] ,boolean[] vis, boolean[] pathvis){
        vis[node] = true;
        pathvis[node] = true;

        for(int nei: graph[node]){
            if(!vis[nei]){
                if(dfs(nei, graph , vis,pathvis)){
                    return true;
                }
            }else if(pathvis[nei]){
            
                return true;
            }
        }
        ans.add(node);
        pathvis[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean vis[] = new boolean[v];
        boolean pathVis[] = new boolean[v];
        ans = new ArrayList<>();

        for(int i = 0; i < v; i++){
            if(!vis[i]){
                dfs(i, graph , vis, pathVis);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    

    public static void main(String[] args) {
        
    }
}
