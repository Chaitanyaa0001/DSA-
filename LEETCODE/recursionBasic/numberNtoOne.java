package LEETCODE.recursionBasic;

import java.util.Scanner;

public class numberNtoOne {
    public static void NtoOne(int n  , int i ){
        if(i == n){
            return;
        }
        System.out.println(n);
        NtoOne(n-1, i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n  = sc.nextInt();

        NtoOne(n,0);
    }
}
