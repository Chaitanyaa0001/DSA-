package LEETCODE.arrays.Medium;

import java.util.Scanner;

import LEETCODE.arrays.ArrayInput;

public class S1_Leetcode1_TwoSum {
    // brute force 
    public static int[] bruteforce(int nums[], int target){

        return new int [] {};
    }
    
    // optiml 
    public static int[] optimalApproch(int nums[], int target){

        return new int [] {};
    }

    
    public static void main(String[] args) {
        int arr[] = ArrayInput.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int target  = sc.nextInt();
        // brute 
        int[] brute = bruteforce(arr, target);
        System.out.println(brute);
        // optimal 
        int[] optimal =  optimalApproch(brute, target);
        System.out.println(optimal);

    }
}
