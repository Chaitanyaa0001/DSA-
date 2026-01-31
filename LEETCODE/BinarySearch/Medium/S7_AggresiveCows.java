package LEETCODE.BinarySearch.Medium;

import java.util.Arrays;
import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S7_AggresiveCows {
    public static boolean checkcowsHelper(int [] nums, int distance, int cows){
        int n  = nums.length;
        int countcows = 1;
        int last = nums[0];
        for(int i = 1; i < n ; i++){
            if(nums[i] - last  >=   distance){
                countcows++;
                last = nums[i];
            }
            if(countcows >  cows){
                return false;
            }
        }
        

        return true;
    }
    public static int brute_force(int[] arr, int cows){
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i : arr){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        int start = 1, end = max - min;

        while (start <= end) {
            int mid = start + (end-start) / 2;

            if(checkcowsHelper(arr, mid, cows) == false){
                end = mid - 1;
            }else{
                start  = mid + 1;
            }
        }
        return end;  
        
    }
    public static void main(String[] args) {
        int[] coordinates = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int cows = sc.nextInt();
    }
}
