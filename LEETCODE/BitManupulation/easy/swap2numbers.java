package LEETCODE.BitManupulation.easy;

import java.util.Scanner;

public class swap2numbers {
    private static void swap(int a, int b){
        // to swap 2 numebrs 
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        swap(a, b);
    }
}
