package LEETCODE.Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * S4_cheapestFlight
 */
public class S4_cheapestFlight {
    class Node {
        int node;
        int weight;
        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    class Pair {
        int stops;
        int node;
        int cost;
        Pair(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new Node(v, w));
        }
        Queue<Pair> queue = new LinkedList<>();
    
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        queue.offer(new Pair(0, src, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int stops = current.stops;
            int node = current.node;
            int currentCost = current.cost;
            // We can take at most k stops => at most k + 1 flights
            if (stops > k) {
                continue;
            }
            for (Node neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int flightCost = neighbor.weight;
                int newCost = currentCost + flightCost;

                if (newCost < cost[nextNode]) {
                    cost[nextNode] = newCost;
                    queue.offer(new Pair(stops + 1, nextNode, newCost));
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }


    public static void main(String[] args) {
        
    }
}