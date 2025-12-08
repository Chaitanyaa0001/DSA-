package LEETCODE.recursionBasic;

import java.util.Scanner;

public class S9_Leetcode_509quesFibnoochi {
    public static int fib(int n){
        if(1 >= n){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fib(n));
    }
}
