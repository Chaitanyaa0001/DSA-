package LEETCODE.BitManupulation.easy;

import java.util.Scanner;

public class S6_Leetcode_ifNumberofPoweris2 {
    private static boolean powof2(int n){
        if(n <= 0){
            return false;
        }

        if((n & (n-1)) == 0){
            return true;
        }
        return false;

        // always remeber our pow of 2 will always have  onny 1 one so we can do & operator 
        // 1000 - 16
        // 0111 - 15
        // 0000 hence its pow of 2 
        // 1101 - 13
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        powof2(n);
        
    }
}
