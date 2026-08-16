package LEETCODE.Graphs.Algorithms;

/**
 * FloydsWarshellAlgorithm
 */
public class FloydsWarshellAlgorithm {

    private static int[][] floydalgorithm(int V, int[][] edges){
        int graph[][] = new int[V][V];

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; i++){
                if(i == j){
                    graph[i][i] = 0;
                }else{
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // graph is 0 based 
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph[u][v] = w;
        }
        for(int it = 0; it < V; it++){

            for(int i = 0; i< graph.length; i++){
                for(int j = 0; j < graph[0].length; j++){

                    if(graph[i][it] != Integer.MAX_VALUE && graph[it][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j],graph[i][it] + graph[it][j]);
                    }           
                }
            }
        }
        // now to detect a cycle 
        for(int i = 0 ; i < V; i++){
            if(graph[i][i] < 0){
                System.out.println("Negative cycle");
                break;
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        int V = 4;

        int[][] edges = {
    {0, 1, 3},
    {1, 0, 8},
    {1, 2, 2},
    {2, 0, 5},
    {2, 3, 1},
    {3, 0, 2},
    {0, 3, 7}
};
        
    }
}