package LEETCODE.arrays.Medium;

public class S11_Leetcode48_rotateMatrix {
    private static void bruteforcewithextraspace(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] ans = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[j][n-1-i] = matrix[i][j];
            }
        }
        
    }

    private static  void optimal(int [][] matrix){
        int n =  matrix.length;  //row 
        int m = matrix[0].length; /// col 

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < m ; j++){
                swap(matrix,i,j);
            }
        }
        // now revrse evrry row 
        for(int i = 0; i < n; i++){
            reverse(matrix,i);
        }
    }
    private static void  reverse(int matrix[][],int row){
        int left = 0;
        int right = matrix[0].length - 1;
        while(left < right){
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
            right--;
        }
    }

    private static void swap(int matrix[][], int a, int b){
        int temp = matrix[a][b];
        matrix[a][b] = matrix[b][a];
        matrix[b][a] = temp;
    }
    
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        bruteforcewithextraspace(matrix);
        optimal(matrix);

    }
}