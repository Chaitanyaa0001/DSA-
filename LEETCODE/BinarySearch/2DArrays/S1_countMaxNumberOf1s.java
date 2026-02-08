import hashing.hashmap.iteration;

public class S1_countMaxNumberOf1s {

    public static int helperLowerBound(int[] arr, int x){
        int low = 0; 
        int high =  arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static int bruteforce(int[][] mat){
        // row 
        int n = mat.length;
        // col 
        int m = mat[0].length;
        int max = -1;
        int index = -1;
        // iteration on row 
        for(int i = 0; i < n; i++){
            // iteration on col 
            int count = 0;
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1){
                    count += mat[i][j];
                }
            }
            if(count > max){
                max = count;
                index = i;
            }
        }
        return max;
    }

    public static int betterApproch(int[][] matrix){
        // tc  n * logm
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0, index = -1;

        for(int i = 0 ; i < n; i++){
            int count =  m - helperLowerBound(matrix[i], 1);
            if(max > count){
                max = count;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        // Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order, find the index of the row with the maximum number of ones.
        // If two rows have the same number of ones, consider the one with a smaller index. If no 1 exists in the matrix, return -1.
        int[][] grid = {{0,0,1,1,1},
                        {0,0,0,0,0},
                        {0,1,1,1,1},
                        {0,0,0,0,0},
                        {0,1,1,1,1}};


    }
}