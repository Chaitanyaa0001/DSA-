package LEETCODE.Graphs.ShortestDistance;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * S3_pathwithMinimumEfforts
 */
public class S3_pathwithMinimumEfforts {
    class pair{
        int difference;
        int row;
        int col;
        pair(int difference, int row, int col){
            this.difference = difference;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int diff[][] = new int[m][n];
        for(int[] i : diff){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        PriorityQueue<pair> pq = new PriorityQueue<pair>((a,b) -> a.difference - b.difference);
        diff[0][0] = 0;
        pq.add(new pair(0,0,0));

        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};

        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.difference;

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(0 <= nr && nr < m && 0 <= nc && nc < n ){

                    int absdiff = Math.abs(heights[r][c]-heights[nr][nc]);
                    int newEffort = Math.max(d, absdiff);

                    if(newEffort < diff[nr][nc]){
                        diff[nr][nc] = newEffort;
                        pq.offer(new pair(newEffort, nr, nc));
                    }
                }
            }
        }

        if(diff[m-1][n-1] != Integer.MAX_VALUE){
            return diff[m-1][n-1];
        }
        return 0;
    }


    public static void main(String[] args) {
        
    }
}