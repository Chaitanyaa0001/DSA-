package A2Darrays;

public class searchMatrix {

    public static boolean findtarget(int matrix [][], int target){
        // taking the last row first element 
        int row = matrix.length -1, col= 0;
        while (row >= 0 && col < matrix.length) {
            if(matrix[row][col] == target){
                return true;
            }else if(target > matrix[row][col]){
                col++;
            }else{
                row --;
            }
        }
        return false;
    }
    // taling last elemnt of first row 
    public static boolean searchhMatrixxx(int[][] matrix, int target) {
        int row = 0; 
        int col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(target > matrix[row][col]){
                row++;
            }else{
                col--;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

       boolean result =  findtarget(matrix, 20);
       boolean resulttt = searchhMatrixxx(matrix, 0);
       
       System.out.println(result);
    }
}
