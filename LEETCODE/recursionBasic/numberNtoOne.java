package LEETCODE.recursionBasic;

import java.util.Scanner;

public class numberNtoOne {
    public static void NtoOne( int n,int a){
        // base confition 
        if(n < a) return;
        System.out.println(n);
        NtoOne(n-1, a);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n  = sc.nextInt();

        NtoOne(n,1);
    }
}
