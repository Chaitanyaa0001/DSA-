package LEETCODE.BinarySearch.Medium;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S5_leetcode_1011_CapacityToShipPacakages {
    public static int checkdays(int[] arr, int capacity){
        int n = arr.length;
        int load = 0;
        int d = 1;
        for(int i = 0; i < n; i++){
            if(load +arr[i] > capacity){
                d++;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }
        return d;
    }
    public static int Binary_Approch(int[] weights , int days){
        int n = weights.length;
        int max = Integer.MIN_VALUE;
        int totalCapacity = 0;
        for(int i : weights){
            max = Math.max(max,i);
            totalCapacity += i;
        }

        int start = max, end = totalCapacity;

        while (end >= start) {
            int mid = start + (end - start) / 2;

            if(checkdays(weights,mid) <= days){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    public static int brute_force(int[] weights, int days){

        int n = weights.length;
        int max = Integer.MIN_VALUE;
        int totalCapacity = 0;
        for(int i : weights){
            max = Math.max(max,i);
            totalCapacity += i;
        }

        for(int i = max; i <= totalCapacity; i++){
            int daysCame = checkdays(weights, i);
            if(daysCame <= days){
                return i;
            }
        }
        return -1;  
    }




    public static void main(String[] args) {
        int weights[] = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
    }
}