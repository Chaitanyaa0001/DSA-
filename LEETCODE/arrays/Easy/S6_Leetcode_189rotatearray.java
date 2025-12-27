// 189. Rotate Array
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
// Example 1:
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
// Constraints:
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105

import java.util.Scanner;



import LEETCODE.arrays.ArrayInput;

public class S6_Leetcode_189rotatearray {
    public static void  roateArrayBydPlaces(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        swaping(nums, 0, n);
        swaping(nums, 0, k-1);
        swaping(nums, k+1, n-1);
        
    }
    public static  void swaping(int[] nums, int start, int end){
        while (end>=start) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = start;
            start++;
            end--;
        }
    }
   
    public static void main(String[] args) {           
        int[] nums = ArrayInput.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        roateArrayBydPlaces(nums, k);

    };
};
