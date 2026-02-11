import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S5_FindMedianIn2DMartix {

    public static int bruteforce(int matrix[][]){
        List<Integer> list = new ArrayList<>();
        int n  = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return  (n * m) / 2;
    }
    public static int upperbound(int matrix[], int x){
        int low = 0; int high = matrix.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(matrix[mid] > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static int helperCountnumbers(int matrix[][], int num){
        int n =  matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            count += upperbound(matrix[i],num);
        }
        return count;
    }
    public static int  optimalApproch(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max,matrix[i][m -1]);
        }

        int required = n * m / 2;

        int low = min, high = max;
        while (low <= high) {
           int mid = low + (high - low) / 2;

           int count = helperCountnumbers(matrix, mid);

           if(count <= required){
               low = mid + 1;
           }else{
               high = mid - 1;
           }
        }

        return low;

    }

    public static void main(String[] args) {
        int [][] matrix = {{1,4,9},
                          {2,5,6},
                          {3,7,8}};

       int result = optimalApproch(matrix);

       System.out.println( result);
        
    }
}
