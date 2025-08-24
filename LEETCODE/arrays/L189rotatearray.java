package LEETCODE.arrays;

import java.util.Scanner;

public class L189rotatearray {
    public static void roatearray(int nums[], int k){
        int n = nums.length;
        k = k % n;
        swaping(nums, 0, n-1);
        swaping(nums, 0, k-1);
        swaping(nums, k, n-1);
    }
    public static void swaping(int nums[],int start,int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    };
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        
        roatearray(nums, 3);
        for (int num : nums) {
            System.out.print(num + " ");
        };
        
    };
};
