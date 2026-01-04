package LEETCODE.arrays.Medium;
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.
// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
// Constraints:
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
// Follow up:
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

public class S10_Leetcode73_2DMatrixSetTozero {
    // brute force 
    public static void  row(int matrix[][], int row){
        for(int i = 0; i < matrix.length; i++){
            if(matrix[row][i] != 0){
                matrix[row][i] = -1;
            };
        }
    }
    public  static void  col(int matrix[][], int col){
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] != 0){
                matrix[i][col] = -1;
            };
        }
    }
    public static void bruteforce(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n ;i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    row(matrix, i);   
                    col(matrix, j);
                }
            }
        }
        for(int i = 0; i < n ;i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }



    // now better  solution 
    public static void  betterapproch(int  matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] Row  = new int[n];
        int[] Col  = new int[m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  < m; j++){
                if(matrix[i][j] == 0){
                    Row[i] = 1;
                    Row[j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(Row[i] == 1 || Col[i] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }



    // best approch 
    
    public static void main(String[] args) {
        int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};
        
    }
}