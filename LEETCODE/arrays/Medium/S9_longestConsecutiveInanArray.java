package LEETCODE.arrays.Medium;

import LEETCODE.arrays.ArrayInput;
import java.util.Arrays;

public class S9_longestConsecutiveInanArray {

    public static int longestConsecutive(int[] nums){
        int n = nums.length;
        int length = 0;

        Arrays.sort(nums);
        for(int i = 1; i <= n-1; i++){
            if(nums[i] < nums[i-1]+1){
                length = i-1;
            }
        }
        return length;
    }

    public static int  betterappproch(int[] nums){
        int longest =1;
        int count = 0;
        int smaller = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > smaller ){

            }
        }
    }

    public static void main(String[] args) {
        int [] nums = ArrayInput.takeArrayInput();
        int result = longestConsecutive(nums);
        System.out.println(result);
    }
}
