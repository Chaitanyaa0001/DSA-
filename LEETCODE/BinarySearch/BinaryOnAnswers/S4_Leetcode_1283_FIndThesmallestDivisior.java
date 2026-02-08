package LEETCODE.BinarySearch.BinaryOnAnswers;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S4_Leetcode_1283_FIndThesmallestDivisior {
    public static int isDivisor(int [] arr, int divisor){
        int n = arr.length;
        int totalDivSum = 0;
        for(int i = 0; i < n; i++){
            totalDivSum +=(int) Math.ceil((double)arr[i] /  divisor);
        }
        return totalDivSum;
    }


    public int smallestDivisor(int[] nums, int threshold) {
        // range -> arr max
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max,nums[i]);
        } 
        int start = 1, end = max;
        while(end >= start){
            int mid = start + (end - start) / 2;
            if(isDivisor(nums,mid) <= threshold){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int threshold = sc.nextInt();
    }
}