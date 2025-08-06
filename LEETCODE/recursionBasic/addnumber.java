package LEETCODE.recursionBasic;

import java.util.Scanner;

//  to calculate the  sum of first 5 numbers using recursion 
public class addnumber {
    public static void sumOfNaturalNUmbers(int a,int n){
        int sum =0;
        // base condition 
        if(a > n) return;
        System.out.println(a);
        sum = sum + a;
        sumOfNaturalNUmbers(a + 1,n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        sumOfNaturalNUmbers(1,n);


    }
    
}
