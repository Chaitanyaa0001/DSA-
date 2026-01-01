// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// // We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// // You must solve this problem without using the library's sort function.
// // Example 1:
// // Input: nums = [2,0,2,1,1,0]
// // Output: [0,0,1,1,2,2]
// // Example 2:
// // Input: nums = [2,0,1]
// // Output: [0,1,2]
// // Constraints:
// // n == nums.length
// // 1 <= n <= 300
// // nums[i] is either 0, 1, or 2.
// // Follow up: Could you come up with a one-pass algorithm using only constant extra space?




package LEETCODE.arrays.Medium;

import LEETCODE.arrays.ArrayInput;

public class S2_Leetcode75_SortColors {
    // by ducks national flag algotithm 

    public static int[] brute(int[] nums){
        int n = nums.length;
        int count = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                count++;
            }else if(nums[i] == 1){
                count1 ++;
            }else{
                count2 ++;
            }
        }

        int index = 0;

        for(int i = 0; i < count; i++){
            nums[index]  = 0;
        }
        for(int i = 0; i < count1; i++){
            nums[index]  = 1;
        }
        for(int i = 0; i < count2; i++){
            nums[index]  = 2;
        }
        return nums;
    }

    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void optimal(int [] nums){
        
        int n = nums.length;
        int low = 0, mid = 0, high = n-1;
        while (mid <= high) {
            if(nums[mid] == 0){
                swap(nums, mid, low);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }   
        }
    }

    
    public static void main(String[] args) {
        // nums = [2,0,2,1,1,0]
        int[] nums = ArrayInput.takeArrayInput();
        // brute(nums);

        optimal(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
    }
}