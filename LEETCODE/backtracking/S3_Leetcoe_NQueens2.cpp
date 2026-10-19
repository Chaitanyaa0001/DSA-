package LEETCODE.backtracking;

import java.util.Scanner;

public class S3_Leetcoe_NQueens2 {

    private static boolean  iSafe(int row, int col, char[][] board, int n){
        // check for col 
        int r = row, c = col;
        for(int i  = 0; i < col; i++){
            if(board[row][col] == 'Q') return false;
        }
        // to check upper diagnal 
        while (r >= 0 && c >= 0) {
            if(board[r][c] == 'Q') return false;
        }
        // to check lower diagnal 
        r = row; c = col;
        while (r < n && c >= 0) {
            if(board[r][c] == 'Q') return false;
        }
        return true;
    }
    private static int nquenns( int col,int n,char [][] board){

        if(n == col){
            return 1;
        }
        int count = 0;
        for(int row  = 0; row <= n; row++){
            if(iSafe(row, col, board, count)){
                board[row][col] = 'Q';
                count +=  nquenns(col, n, board);
                board[row][col] ='.';
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // int this we have to count how many possible solutions are there 
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        char [][] board = new char[n][n];
        nquenns(n, n, board);
    }
}
