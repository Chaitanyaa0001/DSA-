package LEETCODE.arrays.Medium;
import java.util.*;
public class S13_SpiralMatrix {

    private static List<Integer> spiralMatrix(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int left = 0; 
        int right = m - 1; // col
    
        int top = 0;
        int bottom = n -1 ;  // row

        while (top <= bottom && left <= right) {
             // print top 
            for(int i = left; i <=right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            // ptint right 
            for(int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            // print bottom 
            // if agar meri koi row hi nhi bachi to ye dubara print kr dega 
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                 bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
           
        }
        return list;
       


    }
    public static void main(String[] args) {
        int [][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12}
        };
        spiralMatrix(matrix);
    }
}
