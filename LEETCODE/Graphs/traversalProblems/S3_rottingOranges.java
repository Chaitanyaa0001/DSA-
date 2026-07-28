package LEETCODE.Graphs.traversalProblems;

import java.util.LinkedList;
import java.util.Queue;

public class S3_rottingOranges {
    static class Pair{
        int r;
        int c; 
        int t;
        Pair(int r, int c, int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    private static int mintimetorottonOranges(int[][] grid){
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        
        boolean vis[][] = new boolean[m][n];
        // mera find karo konsa konsa orange rotten hai or usko queue mei daldo 
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '2'){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = true;
                    
                }else if(grid[i][j] == '1'){
                    fresh++;
                }
                
            }
        }
        
        int time = 0;
        // up right bottom left 
        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};
        int rotton = 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.r;
            int col = curr.c;
            int t = curr.t;  

            time = Math.max(time,t);

            for(int i = 0; i < 4; i++){
                // 0- up
                // 1 - right
                // 2 - bottom,
                // 3 - left;
                int neighbourRow = row + dr[i];
                int neighbourCol = col + dc[i];
                // agar mera  curr el = () mera range mei hai to hi add kro 
                // 0 <= nrow < m  && 0 <= ncol < n
                if( 0 <= neighbourRow && neighbourRow < m && neighbourCol <= 0 && neighbourCol < n && !vis[neighbourRow][neighbourCol] && grid[neighbourRow][neighbourCol] == 1){
                    q.add(new Pair(neighbourRow, neighbourCol, t+1));
                    vis[neighbourRow][neighbourCol] = true;
                    rotton++;
                }
            }

        }
        // maine jitno ko rotten kiya and mera total fresh kitne the agar dono same gogye to truee other wise false 
        if(rotton != fresh){
            return -1;
        }
        return time;

    }
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{0,1,1}};
        mintimetorottonOranges(grid);

    }
}
