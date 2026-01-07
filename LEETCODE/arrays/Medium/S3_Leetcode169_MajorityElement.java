package LEETCODE.arrays.Medium;

import java.util.HashMap;

import LEETCODE.arrays.ArrayInput;

public class S3_Leetcode169_MajorityElement {
    public static int bruteforce(int nums[]){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int count =0;
            for(int j = 0; j < n; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
                if(count > n / 2){
                    return nums[i];
                }
            }
        }
        return 0;
    }
    public static int better(int nums[]){
        HashMap <Integer,Integer> l = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < nums.length;i++){
            l.put(nums[i], l.getOrDefault(nums[i],0)+1);
        }
        
        for(int num: l.keySet()){
            int i = l.get(num);
            if(i > n / 2){
                return num;
            }
        } 
        return -1;
    }
    public static int optimalApproch(int nums[]){
        int elemnt = 0; 
        int count = 0; 
        
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                elemnt = nums[i];
                count = 1;
            }else if (nums[i] == elemnt){
                count++;
            }else{
                count--;
            }
        }
        return elemnt;
    }

    public static void main(String[] args) {
        int [] arr = ArrayInput.takeArrayInput();
        // nums = {2,2,1,1,1,2,2};
        // int result = better(arr);
        int result = optimalApproch(arr);
        System.out.println(result);
    }
}