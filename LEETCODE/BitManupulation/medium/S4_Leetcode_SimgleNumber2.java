package LEETCODE.BitManupulation.medium;

import java.util.Arrays;

public class S4_Leetcode_SimgleNumber2 {
    // brute force we can do with hashmap 

    // other we can do with    bit manupulation  001 apptoch

    // other we can do it with with pointers 
    private static  int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i+=3){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[n-1];
        // tinme : O(nlogn) + n / 3;
        // sc : O(1)
    }
    // now concepts ot buckets 



    
    

    public static void main(String[] args) {
        int[] nums = {4,4,4,2,5,5,5};
        singleNumber(nums);
    }
}
