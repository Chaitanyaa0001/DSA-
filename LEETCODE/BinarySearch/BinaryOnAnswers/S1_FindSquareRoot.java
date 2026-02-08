package LEETCODE.BinarySearch.BinaryOnAnswers;

import java.util.Scanner;

public class S1_FindSquareRoot {
    public static void linear(int n){
        for(int i = 1; i <= n; i++){
            if(i * i <= n){
                System.out.println(i);
            }else{
                break;
            }
        }
    }

    //  PATTERN: RANGE, MIN or MAX Integers x
    public static int biary_approch(int n){
        int start = 1; 
        int end = n;
        int ans = 0;
        while (end >= start) {
            int mid = start + (end - start) / 2;

            if((mid * mid) <= n){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        linear(n);
        biary_approch(n);
    }
}
