package LEETCODE.Graphs.ShortestDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class S1_FindShortestPath {

    class pair {
        int node;
        int weight;
        pair(int node, int weight) {
            this.node = node;
            this.weight = weight;       // FIX 1: was this.weight = node;
        }
    }
    class QP {
        int nde;
        int dis;
        QP(int nde, int dis) {
            this.nde = nde;
            this.dis = dis;
        }
    }
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();  // FIX 2: pair, not Integer
        // create adj list
        for (int i = 0; i <= V; i++) {       // FIX 3: 0 to V, because vertices are 1 to V
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];              // FIX 4: added ;
            int v = edges[i][1];              // FIX 5: added ;
            int w = edges[i][2];              // FIX 6: added ;
            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }
        int dis[] = new int[V + 1];           // FIX 7: V + 1, not V
        int parent[] = new int[V + 1];        // FIX 8: V + 1, not v
        // FIX 9: initially distance should be infinity
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 1; i <= V; i++) {        // FIX 10: <= V
            parent[i] = i;
        }
        // parent = [0,1,2,3,4,5]

        PriorityQueue<QP> p =
            new PriorityQueue<>((a, b) -> a.dis - b.dis);

        p.add(new QP(src, 0));                // FIX 11: q -> p

        dis[src] = 0;

        while (!p.isEmpty()) {
            QP curr = p.poll();
            int nde = curr.nde;
            int currDis = curr.dis;            // FIX 12: don't use variable name dis
            if (currDis > dis[nde]) {
                continue;
            }
            for (pair nei : adj.get(nde)) {    // FIX 13: pair, not QP
                int u = nei.node;              // FIX 14: pair has node
                int w = nei.weight;            // FIX 15: pair has weight
                if (currDis + w < dis[u]) {
                    dis[u] = currDis + w;
                    parent[u] = nde;
                    p.add(new QP(u, dis[u]));  // FIX 16: add updated node to PQ
                }
            }
        }
        // FIX 17: if destination is unreachable
        if (dis[dest] == Integer.MAX_VALUE) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }
        int n = dest;
        ArrayList<Integer> ans = new ArrayList<>();
        while (parent[n] != n) {
            ans.add(n);
            n = parent[n];
        }
        ans.add(src);                          // FIX 18: was ans.add(1)
        Collections.reverse(ans);              // FIX 19: don't sort; reverse the path
        return ans;
    }
// time : ElogV +  O(n) for while loop 
    public static void main(String[] args) {
        
    }
}
