package LEETCODE.BinarySearch.Easy;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S4_FloorAndCeil {
    public static int[]  floorAndCeil(int[] nums, int x){
        int n = nums.length;
        int start = 0, end = n-1;
        int floor = -1;
        int ceil = -1;
        while ( end >= start) {
           int mid = start + (end - start) / 2;
           if( nums[mid] == x){
            floor = nums[mid];
            ceil = nums[mid];
            break;
           }else if(nums[mid] > x){
               ceil = nums[mid];
               end = mid -1;
            }else{
               floor = nums[mid];
            start = mid + 1;
           }
        }
        return new int[]{floor,ceil};
    }

    public static void main(String[] args) {

        int [] nums = ArrayInp.takeArrayInput();
        int x =  5;

        int [] res = floorAndCeil(nums, x);

        
        System.out.println("Floor: " + res[0]);
        System.out.println("Ceil: " + res[1]);
        
    }
}