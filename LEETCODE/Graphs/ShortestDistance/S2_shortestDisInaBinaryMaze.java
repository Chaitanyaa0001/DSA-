package LEETCODE.Graphs.ShortestDistance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * S2_shortestDisInaBinaryMaze
 */
public class S2_shortestDisInaBinaryMaze {
    
    class pair{
        int dis;
        int row;
        int col;
        pair(int dis, int row, int col){
            this.dis = dis;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        
        int dis[][] = new int[n][n];
        for(int[] i : dis){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(1,0,0));

        dis[0][0] = 1;

        while(!q.isEmpty()){
            pair curr = q.poll();
            int d = curr.dis;
            int r = curr.row;
            int c = curr.col;

            if(d > dis[r][c]){
                continue;
            }

            int dr[] = {-1,-1,0,+1,+1,+1,0,-1};
            int dc[] = {0,+1,+1,+1,0,-1,-1,-1};

            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(0 <= nr && nr < n && 0 <= nc && nc < n && d + 1 < dis[nr][nc] && grid[nr][nc] != 1){
                    dis[nr][nc] = d + 1;
                    q.offer(new pair(d + 1, nr, nc)); 
                }
            }
        }
        if(dis[n-1][n-1] != Integer.MAX_VALUE){
            return dis[n-1][n-1];
        }

        return -1;
    }


    public static void main(String[] args) {
        
    }
}