package LEETCODE.recursionBasic;

import java.util.Scanner;

public class numbers {
    // by backtracking 
    public static void PrintNumbers(int i ){ 
        // 5 5
        // base condition 
        if( i < 1){ 
            // 5 < 1
            return;
        }
        PrintNumbers(i-1);
        System.out.println(i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n:");
        int n = sc.nextInt();

        PrintNumbers(n);   
        
    }
}
