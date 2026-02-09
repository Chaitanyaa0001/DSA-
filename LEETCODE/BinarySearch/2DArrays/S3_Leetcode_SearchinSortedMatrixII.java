public class S3_Leetcode_SearchinSortedMatrixII {

      public static  boolean binaryhelper(int arr[], int target){
        int start = 0; 
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean bruteforce(int[][] array, int target){
        int n = array.length;
        int m = array[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean betterApproch(int[][] arr, int target){
        int n = arr.length;
        int m = arr[0].length;
       int start = 0; 
       int end = m -1; 
        for(int i = 0; i < n; i++){
            if(arr[i][start] <= target && target <= arr[i][end]){
               return  binaryhelper(arr[i], target);
            }
        }
        return false;
    }

    public static boolean optimal(int[][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0; 
        int col = m - 1;
        while (m > 0 && n > 0) {
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col]  > target){
                col --;
            }else{
                row ++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // row wise sorted and col wise sorted
        int grid [][] = {{1,2,3,4,5,6},{2,2,23,4,4,},{3,3,4,6,7,}};
    }
}