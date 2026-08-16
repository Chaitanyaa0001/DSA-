package LEETCODE.Graphs.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstaAlgorithm {
  
    class Pair{
        int node;
        int dis;
        Pair(int node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj  = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.dis - b.dis);
        
        pq.add(new Pair(src,0));
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node  = curr.node;
            int dis = curr.dis;
            
            if (dis > distance[node]) {
                continue;
            }
            for(Pair nei : adj.get(node)){
                int w = nei.dis;
                if(dis +  w < distance[nei.node]){
                    distance[nei.node] = dis + w;
                    pq.offer(new Pair(nei.node, dis + w));
                }
            }
        }
        ArrayList<Integer> ans  = new ArrayList<>();
        for(int i  = 0; i < distance.length; i++){
            ans.add(distance[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
