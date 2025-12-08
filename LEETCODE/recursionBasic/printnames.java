package LEETCODE.recursionBasic;

import java.util.Scanner;

public class printnames {
    public static void printNames(String str, int n ){
        if (n == 0){
            return;
        }
        printNames(str, n-1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number how many times you need to print the name:");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the value of string:");
        String str = sc.nextLine();

        printNames(str, n);
    }
}
