package LEETCODE.Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * S5_networkDelaytime
 */
public class S5_networkDelaytime {
    // to build graph 
    class pair{
        int dst;
        int weight;
        pair(int dst, int weight){
            this.dst = dst;
            this.weight = weight;
        }
    }
    // store in pq 
    class Node{
        int time;
        int node;
        Node(int time, int node){
            this.time = time;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new pair(v,w));
        }
        int mintime = Integer.MIN_VALUE;
        PriorityQueue<Node> q = new PriorityQueue<Node>((a,b)-> a.time - b.time);
        int dis[] = new int[n+1];

        int m = dis.length;

        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k] = 0;
        q.offer(new Node(0,k));

        while(!q.isEmpty()){
            Node curr = q.poll();

            int time = curr.time;
            int node = curr.node;

            if(time > dis[node]){
                continue;
            }

            for(pair nei :adj.get(node)){
                int nde = nei.dst;
                int neiTime = nei.weight;
// [dst, w][dst,w]
                if(neiTime + time < dis[nde]){
                    dis[nde] = neiTime + time;
                    q.offer(new Node(neiTime + time, nde));
                }
            }
        }
        for(int i = 1; i < m; i++){
            if(dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            mintime = Math.max(mintime, dis[i]);
        }

        return mintime;
    }


    public static void main(String[] args) {
        
    }
}