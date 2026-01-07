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

        for(int i = 0; i < nums.length;i++){
            l.put(nums[i], l.getOrDefault(l,0)+1);
        }
        for(int num : nums){
          int i =  l.get(num);
        }
        return 0;
    }
    public static int optimalApproch(int nums[]){
        return 0;
    }

    public static void main(String[] args) {
        int [] arr = ArrayInput.takeArrayInput();
        // nums = {2,2,1,1,1,2,2};
        int result = bruteforce(arr);
        System.out.println(result);
    }
}