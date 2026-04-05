package LEETCODE.BitManupulation.easy;

import java.util.Scanner;

public class S2_checkiThBitIsSetOrNot {
    private static  void check(int n, int i){
        // check if my ith bit of n is set or not means if its one or not 
        // n = 13  -> 1101, i = 2
        // left shift 

        if((n & (1 << i)) != 0){
            System.out.println("True");
        } else{
            System.out.println("false");
        }
    } private static  void check2(int n, int i){
        // check if my ith bit of n is set or not means if its one or not 
        // n = 13  -> 1101, i = 2
        // right shift 
        if(((n >> i) & 1) == 0){
            System.out.println("false");
        } else{
            System.out.println("true");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i =  sc.nextInt();
        check(n, i);
        check2(n, i);
    }
}
