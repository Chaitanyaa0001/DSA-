package LEETCODE.BinarySearch.BinaryOnAnswers;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S9_Leetcode410_painterPartition {
   
    public static int checkfork(int[] arr, int m){
        int n = arr.length;
        int count = 1;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(sum + arr[i] <= m){
                sum += arr[i];
            }else{
                count++;
                sum = arr[i];
            }
        }
        return count;
    }
    public static int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums){
            max = Math.max(max,i);
            sum += i;
        }

        int start = max, end = sum;
        while(start <= end){
            int mid = start + (end-start) / 2;
            if(checkfork(nums,mid) <= k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int [] nums = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); 
    }
}