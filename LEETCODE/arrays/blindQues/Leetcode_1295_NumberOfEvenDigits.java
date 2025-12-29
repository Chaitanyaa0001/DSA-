package LEETCODE.arrays.blindQues;

import LEETCODE.arrays.ArrayInput;

public class Leetcode_1295_NumberOfEvenDigits {
    public static int FindNumberofEvendigits(int[]nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int digits = (int)Math.log10(nums[i]) + 1;
            if(digits % 2 == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = ArrayInput.takeArrayInput();
        System.out.println(FindNumberofEvendigits(nums));
    }
}