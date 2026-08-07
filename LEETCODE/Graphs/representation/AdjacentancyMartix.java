package LEETCODE.Graphs.representation;

public class AdjacentancyMartix {
    public static void main(String[] args) {
         int n = 5;
         int[][] edges = {
                            {0, 1},
                            {0, 2},
                            {1, 2},
                            {1, 3},
                            {2, 4},
                            {3, 4}
                        };

                    // now we can build  graph 

        int[][] graph = new int[n+1][n+1];
        
        for(int i =  0; i < edges.length; i++){
            int u = edges[i][0]; 
            int v = edges[i][1]; 
            
            graph[u][v] = 1;
            graph[v][u] = 1; // for directed grapph we dont write this  as fircted graph is only of onr direction 
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        // 0 1 1 0 0 
        // 1 0 1 1 0 
        // 1 1 0 0 1 
        // 0 1 0 0 1 
        // 0 0 1 1 0
    }
}
