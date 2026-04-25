package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Stack;

public class trappingRainwater {
    public static  int trap(int[] height) {
        // time com :  O(3n)
        //  space : O(2n)
        int n = height.length;
        int[] leftmax = new int[n];

        leftmax[0] = height[0];
        for(int i = 1; i < n; i++){
            // O(n)
            leftmax[i] = Math.max(height[i],leftmax[i-1]);
        }
        int[] rightmax = new int[n];
        rightmax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            // O(n)
            rightmax[i] = Math.max(height[i],rightmax[i+1]);
        }

        int waterlevel = 0;
        int waterTrapped = 0;
        for(int i = 0; i < n; i++){
            // O(n)
            waterlevel = Math.min(leftmax[i], rightmax[i]);
            waterTrapped += waterlevel - height[i];
        }
        return waterTrapped;
    }
    //  2 ponter implementatipn 
    // ----------------------------------------------------------
    private static int  TwoPointer(int nums[]){
        int left  = 0;
        int right = 0;
        int leftmax = 0;
        int rightmax = 0;
        int water  = 0;
        while (left <= right) {
            if(nums[left]  <= nums[right]){
                if(nums[left] >= leftmax){
                    leftmax = nums[left];
                }else{
                    water += leftmax - nums[left];
                }
                left++;
            }else{
                if(nums[right] >= rightmax){
                    rightmax = nums[right];
                }else{
                    water += rightmax - nums[right]
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,4,2,7,4,3,8};
        TwoPointer(nums);


    }
}
