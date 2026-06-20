package LEETCODE.greedyApproch.easy;

public class S4Jump3 {
   
    private static boolean dfs(int arr[], int index, boolean visited[]){
        if(index <0 || index >= arr.length){
            return false;
        }
        if(visited[index]){
            return false;
        }
        visited[index] = true;
        if(arr[index] == 0){
            return true;
        }
        return dfs(arr, index + arr[index],visited) || dfs(arr,index-arr[index], visited);
    }
    public static boolean canReach(int[] arr, int start) {
        boolean visited[] = new boolean[arr.length];
        
         return dfs(arr,start,visited); 
    }

    public static void main(String[] args) {
        int arr[] = {4,2,3,0,3,2};
        canReach(arr, 5);
        
    }
}
