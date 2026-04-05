package LEETCODE.BitManupulation.easy;

import java.util.Scanner;

public class S4_ClearIthBit {
    private static int clear(int n, int i){
        // i  = 2 n = 13-> 1101 ===> 1001
        // we can do with xor
        return  n & ~ (1 << i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        n =  clear(n, i);
        System.out.println(n);
    }
}
