package LEETCODE.arrays.Medium;

import java.util.*;

import LEETCODE.arrays.ArrayInput;
public class S7_Leetcode2149reaarangetheSIgns {
    public static int[]  brutesignArrays(int [] nums){
        int n = nums.length;
        ArrayList <Integer> pos = new ArrayList<>(); 
        ArrayList <Integer> neg = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            if(nums[i]>0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }

        for(int i = 0; i < n/2; i++){
            nums[2*i] =  pos.get(i);
            nums[2*i + 1] = neg.get(i);
        }
        return nums ;
    }

    public static int [] optimal(int[] nums){
        int n = nums.length;
        int [] ans =  new int[n];
        int x = 0;
        int positive = 0; 
        int negative = 1;
        for(int i = 0; i < n; i++){
            if(nums[i]>0){
                ans[positive] = nums[i];
                positive = positive+2;
            }else if(nums[i]<0){
                ans[negative]  = nums[i];
                negative = negative+2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = ArrayInput.takeArrayInput();

        // int[] ans = brutesignArrays(nums);
        // System.out.println(Arrays.toString(ans));

         int[] ans2 = optimal(nums);
        System.out.println(Arrays.toString(ans2));

    }
}