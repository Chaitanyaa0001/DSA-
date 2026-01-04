package LEETCODE.arrays.Medium;

public class S11_Leetcode48_rotateMatrix {
    public static void bruteforcewithextraspace(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] ans = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

    }
}