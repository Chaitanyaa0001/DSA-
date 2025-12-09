package LEETCODE.hashing;


import java.util.*;

public class S1_Hashing {

    public static void calculateFrequency(int[] arr, int q){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == q){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array (no messages)
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // Number of queries
        int q = sc.nextInt();

        // For each query read a number and print its frequency
        for(int i = 0; i < q; i++){
            int x = sc.nextInt();
            calculateFrequency(arr, x);
        }
    }
}
