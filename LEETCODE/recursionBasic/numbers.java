package LEETCODE.recursionBasic;

import java.util.Scanner;

public class numbers {

    public static void PrintNumbers(int i ,int n){
       if(i > n) return;
        System.out.println(i);
        PrintNumbers(i+1,n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n:");
        int n = sc.nextInt();

        PrintNumbers(1,n);
        
    }
}
