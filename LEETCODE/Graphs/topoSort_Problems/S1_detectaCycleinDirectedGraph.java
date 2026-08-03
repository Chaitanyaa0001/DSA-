package LEETCODE.Graphs.topoSort_Problems;

public class S1_detectaCycleinDirectedGraph {
    private static boolean  dfs(int node, int[][] graph, boolean vis[], boolean pathvis[]){

        vis[node] = true;
        pathvis[node] = true;
        for(int nei : graph[node]){
            if(!vis[nei]){
                if(dfs(nei, graph, vis, pathvis)){
                    return true;
                }
            }else if( pathvis[nei]){
                return true;
            }
        }
        pathvis[node] = false;
        return false;
    }

    private static void detectacyle(int[][] graph){
        boolean pathvis[] = new boolean[graph.length];
        boolean vis[] = new boolean[graph.length];
        int v = graph.length;
        for(int i = 0; i < v; i++){
            if(!vis[i]){
                dfs(i,graph, vis, pathvis);
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{},{2},{3},{4, 6},{5},{}, {5},      {2, 8},   {9},      {7}       };
        detectacyle(graph);
    }
}
