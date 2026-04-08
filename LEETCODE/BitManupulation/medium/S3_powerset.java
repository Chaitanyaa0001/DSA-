package LEETCODE.BitManupulation.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S3_powerset {
    private static List<List<Integer>> powse(int[] arr){
        int n = arr.length;
        int subset = 1 << n;  // 2 raise to pow n    
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < subset; i++){
            List<Integer> list  = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    public static void main(String[] args) {
        // int this we need to rpint the subsets 
        int arr[] = {1,2,3};
        

    }
}
