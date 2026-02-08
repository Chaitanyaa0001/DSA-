package LEETCODE.BinarySearch.BinaryOnAnswers;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S3_Leetcode_Bloomsday {
    public static int possible(int[] arr,int day ,int m, int k){
        int n = arr.length;
        int count = 0;
        int boque = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= day){
                count++;
            }else{
                boque += count / k; 
                count = 0;
            }
        }

        boque += count / k; 

        return boque;
    }


    public static int Binary_Approch(int[] arr, int m, int k){
        int n = arr.length;
        if(m * k > n){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int start = min, end  = max;
        while (end >= start) {
            int mid = start + (end - start) / 2;

            if(possible(arr, mid, m, k) >= m){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static int brute_force(int[] bloomsDay, int m, int k){
        int n = bloomsDay.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++){
            // min 
            min = Math.min(bloomsDay[i], min);
            // max 
            max = Math.max(bloomsDay[i], max);
        }
        

        for(int i  = min; i <= max; i++){
            if(possible(bloomsDay, i, m, k) == m){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int [] BloomsDay = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int m  = sc.nextInt();
        int k = sc.nextInt();
    }
}
