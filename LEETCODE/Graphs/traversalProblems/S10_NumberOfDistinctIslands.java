package LEETCODE.Graphs.traversalProblems;


import java.util.*;

public class S10_NumberOfDistinctIslands {
    
   
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    private ArrayList<String> bfs(int row, int col, int m, int n, boolean[][] vis, char[][] grid){
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(row,col));
        vis[row][col] = true;
        
        ArrayList<String> shape = new ArrayList<>();
        int br = row;
        int bc = col;
        
        int[] dr = {-1,0,+1,0};
        int[] dc = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            Pair curr = q.poll(); 
            int r = curr.r;
            int c = curr.c;
            // Two islands are considered distinct if their shapes are different.c;
            shape.add((r - br) + "," + (c - bc));
    
            
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(0 <= nr && nr < m && 0 <= nc && nc < n && !vis[nr][nc] && grid[nr][nc] == 'L'){
                    q.offer(new Pair(nr,nc));
                    vis[nr][nc] = true;
                }
            }
        }
        return shape;
    }
    public int countDistinctIslands(char[][] grid) {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        for(int i = 0; i < m; i++){ // for every row 
            for(int j = 0; j < n; j++){ // for every col
                if(!vis[i][j] && grid[i][j] == 'L'){
                    ArrayList<String> shape =  bfs(i, j, m, n,vis, grid);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        
    }
}
