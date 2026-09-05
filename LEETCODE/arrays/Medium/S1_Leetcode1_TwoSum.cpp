package LEETCODE.arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import LEETCODE.arrays.ArrayInput;

public class S1_Leetcode1_TwoSum {
    // brute force 
    private static int[] bruteforce(int nums[], int target){
        int n = nums.length;
        for(int i = 0; i < n; i++ ){
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    return new  int[] {i,j};
                }
            }
        }
        return new int [] {};
    }
    // better 
    private static int[] betterApproch(int nums[], int target){
        int n = nums.length;
        HashMap<Integer,Integer> hm =  new HashMap<>();
        for(int i = 0 ; i < n; i ++){
            if(hm.containsKey(target - nums[i])){
                return new int[] {i, hm.get(target-nums[i])};
            }
            hm.put(nums[i], i);
        }
        return new int [] {};
    }
// optimal 
    private static int[] optimalApproch(int [] nums, int target){
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        int i = 0; int j = n-1;
        while(i <= j){
            sum = nums[i] + nums[j];
            if(sum > target){
                j--;
            }else if( sum < target){
                i++;
            }else{
                return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }


    
    public static void main(String[] args) {
        int arr[] = ArrayInput.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int target  = sc.nextInt();
        // brute 
        int[] brute = bruteforce(arr, target);
        System.out.println(Arrays.toString(brute));
        
        int[] optimal = optimalApproch(arr, target);
        System.out.println(Arrays.toString(optimal));

        betterApproch(optimal, target);
        sc.close();
    }
}
