package LEETCODE.Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * PrismsAlgorithm
 */
public class PrismsAlgorithm {
    static class Data{
        int weight;
        int node;
        int parent;
        Data(int weight, int node, int parent){
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }
    static class Pair{
        int n;
        int val;
        Pair(int n, int val){
            this.n = n;
            this.val = val;
        }
    }
    private static List<List<Integer>> prismsalgo(int V,int edges[][]){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));

        }
        List<List<Integer>> mst = new ArrayList<>();
        PriorityQueue<Data> q = new PriorityQueue<Data>((a,b) -> a.weight - b.weight);
        boolean vis[] = new boolean[V];
        q.offer(new Data(0, 0, -1));
        int sum = 0;
        while (!q.isEmpty()) {
            Data curr = q.poll();
            int weight = curr.weight;
            int node = curr.node;
            int parent = curr.parent;
            if(vis[node]){
                continue;
            }

            vis[node] = true;

            if(parent != -1){
                sum += weight;
                mst.add(Arrays.asList(parent,node));
            }
            
            for(Pair nei : adj.get(node)){
                int u = nei.n;
                int w = nei.val;

                if(!vis[u]){
                    q.offer(new Data(w, u, node));
                }
            }
        }
        return mst;
    }
    public static void main(String[] args) {
        int adjlist[][] = new int[3][3];
    }
}