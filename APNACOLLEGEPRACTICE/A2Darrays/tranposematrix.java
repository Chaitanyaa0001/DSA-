package A2Darrays;

import java.util.Arrays;

public class tranposematrix {
    public static int[][] Tranpose(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int transpose[][] =  new int[m][n];
        for(int i = 0; i< n; i++){
            for(int j = 0; j<m;j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
    public static void main(String[] args) {
        int matrix [][] = {{11,12,13},{21,22,23}};
        int [][] result =  Tranpose(matrix);
        System.out.println(Arrays.deepToString(result));
    }
}
