package LEETCODE.BinarySearch.Medium;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S6_Leetcode_KMissingPositiveNumber {
    public static int brute_force(int arr[], int k){
        int n  = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] < k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
    public static int Binary_Approch(int arr[], int k){
        int n = arr.length;
        int start = 0; 
        int end = n -1;
        while (end >= start) {
           int mid = start + (end - start) / 2;
           int missing = arr[mid] - (mid + 1);

           if(missing  < k){
                start = mid + 1;
           }else{
                end = mid - 1;
           }
        }
        return end - k + 1;
    }

    public static void main(String[] args) {
        int [] arr = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

    }
}