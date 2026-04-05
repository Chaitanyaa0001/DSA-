package LEETCODE.BitManupulation.easy;

import java.util.Scanner;

public class S3_SetithBit {
    private static int setbit(int n, int i){
        return (1 << i) | n;  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
       n =  setbit(n, i);
       System.out.println(n);
    }
}
