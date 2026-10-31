package LEETCODE.Graphs.Algorithms;
import java.util.*;

/**
 * KahnsAlgorithm_BFS_Topo
 */
public class KahnsAlgorithm_BFS_Topo {
    private static void kahnsalgoBFS(int graph[][], int[] inorder, int v, List<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            //  0 and 1 
            ans.add(curr);
           
            for(int nei : graph[curr]){
                    inorder[nei]--;  
                if(inorder[nei] == 0){
                    q.add(nei);
                }
            }
        }
    }
    private static List<Integer> kahnsAlgo(int[][] graph){
        List<Integer> ans = new ArrayList<>();
        int v = graph.length;
        int[] inorder = new int[v];

        // now calculate inorder 

        for(int i =0 ; i < graph.length; i++){
            for(int nei : graph[i]){
                inorder[nei]++;
            }
        }
        // now bfs 
        kahnsalgoBFS(graph, inorder, v, ans);
        return ans;
    }
    public static void main(String[] args) {
        int[][] graph = {{},{},{3},{1},{0, 1},{0, 2}};        
        kahnsAlgo(graph);

    }
}