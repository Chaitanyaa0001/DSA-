package LEETCODE.Graphs.traversalProblems;

import java.util.Arrays;

public class S12_BipartiteGraphDFS {
    private static boolean dfs(int node, int prevcolor, int[] color, int graph[][]){

        for(int nei : graph[node]){
            if(color[nei] == -1){
                int newcolor = 1 - prevcolor;

                color[nei] = newcolor;
                if(!dfs(nei,newcolor ,color, graph)){
                    return false;
                }
                
            }else if(color[nei]  == color[node]){
                return false;
            }
        }
        return true;
    }
    private static boolean detectcolorgraph(int graph[][]){
        int n = graph.length;
        int color[] = new int[n];
       Arrays.fill(color,-1);
       color[0] = 0;
        if(!dfs(0, 0, color, graph)){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
