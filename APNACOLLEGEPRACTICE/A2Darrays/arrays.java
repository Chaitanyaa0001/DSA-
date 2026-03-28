package A2Darrays;

import java.util.Scanner;

public class arrays {
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        // number of rows 
        int n = matrix.length;
        // number of columns 
        int m = matrix[0].length;
        // now input  
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i< n; i++ ){
            for(int j = 0; j < m; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // output 
        for(int i = 0; i< n; i++ ){
            for(int j = 0; j < m; j ++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        
    }
}
