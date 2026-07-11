package LEETCODE.arrays.Medium;

public class S12_transposeMatrix {
    private static  int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][i] = matrix[i][j];
            }
        }   
        return ans;
    }

    public static void main(String[] args) {
        int [][] a = {{1,2,2},{2,3,4}};
        transpose(a);
    }
}
