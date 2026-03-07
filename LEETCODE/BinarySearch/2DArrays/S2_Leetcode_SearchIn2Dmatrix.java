import java.util.Scanner;

public class S2_Leetcode_SearchIn2Dmatrix {
    private static  boolean binaryhelper(int arr[], int target){
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
    private static boolean bruteforce(int[][] array, int target){
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
    private static boolean betterApproch(int[][] arr, int target){
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

    private static boolean optimal(int arr[][], int target ){
        int n = arr.length, m = arr[0].length;
        int low = 0, high =  n * m -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / 4;
            int col = mid % 4;
            if(arr[row][col] == target){
                return true;
            }else if (arr[row][col] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }


    private static void main(String[] args) {
         int [][] matrix  = {{3,4,7,9},{12,13,16,18},{20,21,23,29}};
    Scanner sc = new Scanner(System.in);
    int target = sc.nextInt();
    }
}