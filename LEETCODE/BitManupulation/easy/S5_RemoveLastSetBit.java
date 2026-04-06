package LEETCODE.BitManupulation.easy;

import java.util.Scanner;

public class S5_RemoveLastSetBit {
    private static int  setrightmostbit(int n){
        // we need to remove the right ost bit of any binary number and toggle it 
        return ( n & n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        setrightmostbit(n);
    }
}
