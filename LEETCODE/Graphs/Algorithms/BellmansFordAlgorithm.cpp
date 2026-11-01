package LEETCODE.Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmansFordAlgorithm {
     
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        ArrayList<Integer> ans = new ArrayList<>();

        int[] dis = new int[V];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        // V-1 normal iterations + 1 negative cycle check
        for(int i = 1; i <= V; i++) {

            for(int j = 0; j < edges.length; j++) {

                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                if(dis[u] != Integer.MAX_VALUE &&
                   dis[u] + w < dis[v]) {

                    dis[v] = dis[u] + w;

                    // V-th iteration => negative cycle
                    if(i == V) {
                        ans.add(-1);
                        return ans;
                    }
                }
            }
        }

        // Convert unreachable vertices to 10^8
        for(int i = 0; i < V; i++) {

            if(dis[i] == Integer.MAX_VALUE) {
                ans.add((int)1e8);
            } else {
                ans.add(dis[i]);
            }
        }

        return ans;
    }

    // or striver one 

    class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {

        ArrayList<Integer> ans = new ArrayList<>();

        int[] dis = new int[V];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        // V-1 normal iterations + 1 negative cycle check
        for(int i = 1; i <= V; i++) {

            for(int j = 0; j < edges.length; j++) {

                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];

                if(dis[u] != Integer.MAX_VALUE &&
                   dis[u] + w < dis[v]) {

                    dis[v] = dis[u] + w;

                    // V-th iteration => negative cycle
                    if(i == V) {
                        ans.add(-1);
                        return ans;
                    }
                }
            }
        }
        for(int j = 0; j < edges.length; j++) {

            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];

            if(dis[u] != Integer.MAX_VALUE &&
               dis[u] + w < dis[v]) {
                ans.add(-1);
                return ans;
                // V-th iteration => negative cycle

            }
        }

        // Convert unreachable vertices to 10^8
        for(int i = 0; i < V; i++) {
            if(dis[i] == Integer.MAX_VALUE) {
                ans.add((int)1e8);
            } else {
                ans.add(dis[i]);
            }
        }

        return ans;
    }
}
    public static void main(String[] args) {
        
    }
}
