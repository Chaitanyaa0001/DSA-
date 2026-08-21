/**
 * S16_leadersInanArray
 */
import java.util.*;
public class S16_leadersInanArray {
    private static ArrayList<Integer>  leaders(int arr[]){
        int n= arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int max = -1;
        for(int i = n -1 ; i >= 0; i--){
            if(arr[i] > max){
                ans.add(arr[i]);
            }
            max = Math.max(max,arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10,22,12,3,0,6};
    }
}