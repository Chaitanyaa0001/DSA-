package A2Darrays;

public class diagnolmatrix {
    // public static int diagnolmatrixsum(int matrix [][]){
    //     int sum = 0;
    //     int n = matrix.length;
    //     int m  = matrix[0].length;
    //     for(int i = 0; i< n; i++){
    //         for(int j = 0; j < m; j++){
    //             // for primary diagnol 
    //             if(i == j){
    //                 sum += matrix[i][j];
    //             }else if(i+j == matrix.length-1){
    //                 sum += matrix[i][j   ];
    //             }
    //         }
    //     }
    //     return sum;
    // }

    public static int optimalcode(int matrix [][]){
        int sum = 0;
        for(int i = 0; i< matrix.length;i++){
            // pd
            sum += matrix[i][i];
            if(i != matrix.length -1-i){
                sum += matrix[i][i];
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        int matrix [][] = {{1,2,3},{4,5,6},{7,8,9}};
        //    int result = diagnolmatrixsum(matrix);
        int result = optimalcode(matrix);
        System.out.println(result);

    }
}
