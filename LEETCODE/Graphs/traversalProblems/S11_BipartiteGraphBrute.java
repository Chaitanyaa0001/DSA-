package LEETCODE.Graphs.traversalProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class S11_BipartiteGraphBrute {

    private boolean biprtitegraph(int[][] mat){
        int v = mat.length;
        int[] color = new int[v];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        color[0] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();

            for(int nei : mat[node]){
                if(color[nei] == -1){
                    color[nei] = 1 - color[node];
                }else if( color[nei] == color[node]){
                    return false;
                }
            }

        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
