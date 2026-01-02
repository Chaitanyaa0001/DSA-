package LEETCODE.arrays.Medium;

import LEETCODE.arrays.ArrayInput;

public class S4_Leetcode_53MaxsubArrayKadan {
    public static int  kadansAlgo(int[] nums){
        int n = nums.length;
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            sum = sum + nums[i];
            maxsum = Math.max(maxsum, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int [] nums = ArrayInput.takeArrayInput();
        kadansAlgo(nums);
    }
}