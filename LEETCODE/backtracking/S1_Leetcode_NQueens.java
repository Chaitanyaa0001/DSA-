package LEETCODE.backtracking;
import java.util.*;
public class S1_Leetcode_NQueens {
    private static boolean isSafe(int row, int col, char[][] board, int n){
        // to check row 
        for(int i = 0; i <= col; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        // to check col 
        for(int i  = 0; i<= row; i++){
            if(board[i][col] == 'Q') {
                return false;
            
            }
        }
        // now to check upper left diagnal and lower left diagnal 
        for(int i = row,j = col; i >= 0  && j >= 0; i--, j--){
            if(board[row][col] == 'Q'){
                return false;
            }
        }
        return false;
        
    }
    private static void backtrack(char[][] board, int col, int n, List<List<String>> ans){

        if(col ==  ans.size()){
            List<String> temp = new ArrayList<>();
            for(char [] row : board){
                temp.add(new String(row));
            }
        }
        for(int  row = 0; row <= n; row++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 'Q';
                backtrack(board, col, n, ans);
                board[row][col] = '.';
            }
        }
    }

    private static List<List<String>> nQueens(int n){
        // reuslt ans store krvane ke liye 
        List<List<String>> ans = new ArrayList<>();
        // board jo mera ans mei store hoga 
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row,'.');
        }
        backtrack(board,0,n,ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
}