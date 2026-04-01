package LEETCODE.backtracking;

import java.util.ArrayList;
import java.util.List;

public class S4_RatInaMAze {
    private static void backtrack(int row, int col ,int[][]arr, int n ,String path, boolean[][] visited, List<String> res){

        if(row == n - 1 && col == n - 1){
            res.add(path);
            return;
        }
        // to check down
        if(row + 1 < n && !visited[row+1][col] && arr[row+1][col] == 1){
            visited[row][col] = true;
            backtrack(row+1, col, arr, n, path + 'D', visited, res);
            visited[row][col] = false;
        }
        // to check left 
        if(col -1 >= 0 && !visited[row][col-1] && arr[row][col-1] == 1){
            visited[row][col] = true;
            backtrack(row, col-1, arr, n, path + 'L', visited, res);
            visited[row][col] = false;
        }
        // to chek right 
        if(col + 1 < n && !visited[row][col+1] && arr[row][col+1] == 1){
            visited[row][col] = true;
            backtrack(row, col+1, arr, n, path + 'R', visited, res);
            visited[row][col] = false;
        }
        // to check up 
        if(row - 1 >= 0 && !visited[row-1][col] && arr[row-1][col] == 1){
            visited[row][col] = true;
            backtrack(row -1 ,col, arr, n, path + 'U', visited, res);
            visited[row][col] = false;
        }

    }

    private static List<String> findpath(int[][] maze , int n){
        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        String path = "";
        backtrack(0, 0, maze, n,path, visited, ans);
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr =  {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1} };
        int n = 4;
        boolean[][] visited  = new boolean[n][n];
        findpath(arr, n);
    }
}
