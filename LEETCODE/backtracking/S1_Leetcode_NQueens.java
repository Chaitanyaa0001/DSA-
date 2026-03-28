package LEETCODE.backtracking;
import java.util.*;
public class S1_Leetcode_NQueens {
    private static boolean isSafr(int row, int col, char[][] board, int n){
        // to check row 
        for(int i = 0; i <= col; i++){
            if(board[row][i] == 'Q'){
                return false;
            }else{
                return true;
            }
        }
        for(int i = 0; i )
    }
    private static void backtrack(char[][] board, int col, int n, List<List<String>> ans){

        for(int  row = 0; row <= n; row++){
            
            board[row][col] = 'Q';
            backtrack(board, col, n, ans);
            board[row][col] = '.';
        }
    }

    private static List<List<Integer>> nQueens(int n){
        // reuslt ans store krvane ke liye 
        List<List<String>> ans = new ArrayList<>();
        // board jo mera ans mei store hoga 
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row,'.');
        }
        backtrack(board,0,n,ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
}