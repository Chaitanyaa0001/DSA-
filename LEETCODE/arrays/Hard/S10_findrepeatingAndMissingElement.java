package LEETCODE.arrays.Hard;

import java.util.Arrays;
import java.util.HashMap;

import LEETCODE.arrays.ArrayInput;

public class S10_findrepeatingAndMissingElement {
    public static int[] bruteforce(int[] nums){
        int[] ans = new int[2];
        int n = nums.length;
        int actualsum =  ((n + 1) * n) / 2;
        int sum = 0;

        for(int i = 0 ; i < n; i++){
            sum =  sum + nums[i] ;
        }
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
                if(count == 2){
                    ans[0] = nums[i];
                    
                }
            }
        }
        int elm = (actualsum - sum) + ans[0] ;
        ans[1] =  elm;
       
        return ans;
    }


    public static int[] better(int nums[]){
        int[] ans = new int[2];
        int n = nums.length;
        int actualsum =  ((n + 1) * n) / 2;
        int sum = 0;

        
        HashMap <Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        for(int num : hm.keySet()){
            if(hm.get(num) == 2){
                ans[0] = num;
                break;
            }
        }
        for(int i = 0 ; i < n; i++){
            sum =  sum + nums[i] ;
        }
        ans[1] = (actualsum - sum) + ans[0] ;
        
       
        return ans;   
    }
    public static void main(String[] args) {
        int [] nums = ArrayInput.takeArrayInput();
       
        int [] result = bruteforce(nums);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i] + " ");
             
        }

      
    }
}
