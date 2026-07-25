package LEETCODE.Graphs.representation;

import java.util.ArrayList;

public class AdjacencyList {
    public static void main(String[] args) {
        int n = 5;
        int edges[][] = {{1,2},{1,3},{2,4},{3,4},{2,5},{4,5}};
        // now in this we store each elemnt neighbours 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // for 1 index graph we have to create n + 1 list and for 0 index graph we can only do till n 
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);

        }
        // Print the graph
        for (int i = 0; i < n; i++) {

            System.out.print(i + " -> ");

            for (int neighbor : graph.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }
}
