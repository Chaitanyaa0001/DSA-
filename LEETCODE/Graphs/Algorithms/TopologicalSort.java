package LEETCODE.Graphs.Algorithms;
import java.util.*;


public class TopologicalSort {
    private  static void dfs(int node, boolean vis[], Stack<Integer> st,  int[][] graph){
        vis[node] = true;

        for(int nei : graph[node]){
            if(!vis[nei]){
                dfs(nei, vis, st, graph);
            }
        }

        st.add(node);
    }

    private  static List<Integer>   topologicalsort(int graph[][]){
        List<Integer> ans = new ArrayList<>();
        int v = graph.length;
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < v; i++){
            if(!vis[i]){
                dfs(i, vis, st, graph);
            }
        }
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }
    public static void main(String[] args) {
        int graph[][] = {{2,1},{2,1},{3,1},{9,2},{1,2},{2,3},{9,7}};  
        topologicalsort(graph);
    }
}
