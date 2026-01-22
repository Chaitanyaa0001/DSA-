package LEETCODE.BinarySearch.Easy;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S3_LowerBound {
    public static  int  lower_Bound(int[] nums, int x){
        int ans = nums.length;
        int start = 0, end = nums.length -1;
        while (end >= start) {
            int mid = start + (end-start) /2;
            if(nums[mid] > x ){
                ans = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return  ans;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int[] nums = ArrayInp.takeArrayInput();
        int x = sc.nextInt();
        System.out.println(lower_Bound(nums, x));
    }
}