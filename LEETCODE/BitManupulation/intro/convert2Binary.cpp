package LEETCODE.BitManupulation.intro;

import java.util.Scanner;

public class convert2Binary {
    private static String convert2binary(int n){
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int bit = n & 1;
            sb.append(bit);
            n = n >> 1;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
       String res =  convert2binary(n);
       System.out.println(res);
        sc.close();
    }
}
