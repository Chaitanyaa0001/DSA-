package LEETCODE.BitManupulation.intro;

import java.util.Scanner;

public class convert2Binary {
    private static String convert2binary(int n){
        String ans = "";

        while (n != 1) {
            if(n % 2 == 1) {
                ans += '1';
            }else{
                ans += '0';
            }
            n  = n / 2;
        }
        return  ans;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        convert2binary(n);
    }
}
