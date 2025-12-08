package LEETCODE.recursionBasic;

import java.util.Scanner;

//  to calculate the  sum of first 5 numbers using recursion 
public class addnumber {
    public static int sumOfNaturalNUmbers(int n){
        if(n == 0){
            return 0;
        }
        return n + sumOfNaturalNUmbers(n-1);
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

       int result =  sumOfNaturalNUmbers(n);
       System.out.println("Sum:"+result);
    };
};
