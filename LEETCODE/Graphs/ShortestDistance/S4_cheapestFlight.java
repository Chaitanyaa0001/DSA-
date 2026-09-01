package LEETCODE.Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * S4_cheapestFlight
 */
public class S4_cheapestFlight {
    class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    class Data{
        int stops;
        int node;
        int cost;
        Data(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0; i < n; i++){
            adj.add(new ArrayList<>());   
        }
        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v  = flights[i][1];
            int w = flights[0][2];
            adj.get(u).add(new Pair(v, w));
        }
        PriorityQueue<Data> q = new PriorityQueue<Data>((a,b)->  a.stops - b.stops); 
        q.add(new Data(0, src, 0));
        int cost[] = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        while (!q.isEmpty()) {
            Data curr = q.poll();
            int stop = curr.stops;
            int node = curr.node; 
            int currentCost = curr.cost;

            for(Pair nei : adj.get(node)){
                int u = nei.node;
                int w = nei.weight;
                
                if(currentCost + w <= cost[u] && stop <= k){
                    cost[u] = currentCost + w;
                    q.offer(new Data(stop+1, u, currentCost + w));
                }
            }
        }
        if(cost[dst] != Integer.MAX_VALUE){
            return cost[dst];
        }
        return -1;
    }


    public static void main(String[] args) {
        
    }
}