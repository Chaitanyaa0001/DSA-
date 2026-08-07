package LEETCODE.Graphs.traversalProblems;

import java.util.*;

public class S1_NumberOfProvience {


    private static void bfs(int node, int[][] connected, boolean[] vis, int col){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int nde = q.poll();

            for(int i  = 0; i < col; i++){
                // ab agar mera node visited nhi hai && or agar mera next neighbour connected neighbout 
                // curr = 1 ab mera 1 kis kis se conncted hai to merko har col mei check krna hai 
                if(!vis[i] && connected[nde][i] == 1){ // agar meri node visited nhi hai to 
                    vis[i] = true;
                    q.offer(i);
                }
            }
        }
    }
    public static  int findCircleNum(int[][] isConnected) {
        int v = isConnected.length; // total number of nodes 
        int col = isConnected[0].length;
        int  p = 0;
        boolean vis[] = new boolean[v];

        for(int i = 0; i < v; i++){
            if(vis[i] == false){
                p++;
                bfs(i, isConnected, vis, col);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                                {1, 1, 0, 0, 0},
                                {1, 1, 1, 0, 0},
                                {0, 1, 1, 0, 0},
                                {0, 0, 0, 1, 1},
                                {0, 0, 0, 1, 1}
                            };
                            // 0 ---- 1 ---- 2

                            // 3 ---- 4
                            findCircleNum(isConnected);

    }
}
