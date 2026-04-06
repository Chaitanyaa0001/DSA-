package LEETCODE.BitManupulation.easy;

import java.util.Scanner;

public class S7_CountTheNumberOfBits {
    // brute 
    private static int count(int n){
        int count = 0;
        while (n > 1) {
            if(n % 2 == 1){
                count++;
            }
            n = n / 2;
            if(n == 1){
                count++;
            }
        };
        return count;
    }

    // now we can do also with bit manupulation as bit task are faster 
    private static int optimalapproch(int n){
        int count = 0;
        while (n > 1) {
            if((n &  1) == 0){  // odd check 
                count++;             
            }
            n = n >> 1;     // -> n / 2

            if(n == 1){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count(n);
        optimalapproch(n);
    } 
    

}
