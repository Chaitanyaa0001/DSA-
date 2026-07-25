package LEETCODE.Graphs.representation;
import java.util.*;
public class weightedGraph {
    private static void  forMatrix(int[][] edges, int n, int graph[][]){
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];// soruce
            int v = edges[i][1]; // destination 
            int w = edges[0][2]; // weight

            graph[u][v] = w;
            graph[v][u] = w; // for directed we cant do this as it is only for one direction
        }
    }
    static class Pair{
        int desination;
        int weight;
        Pair(int desination, int weight){
            this.desination = desination;
            this.weight = weight;
        }
    }
    private static  void forList(int[][] edges, int n,List<List<Pair>> graph){

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];// source 
            int v = edges[i][1]; // destination
            int w = edges[i][2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w)); // for directed we can remove this 

        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                        {0, 1, 5},
                        {0, 2, 2},
                        {1, 3, 4},
                        {2, 4, 1},
                        {3, 4, 7}};
        int graph[][] = new int[n][n];
        forMatrix(edges,n,graph);
        List<List<Pair>> graphh = new ArrayList<>();
        forList(edges, n, graphh);
        
        
    }
}
