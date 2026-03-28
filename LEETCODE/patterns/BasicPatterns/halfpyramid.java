package LEETCODE.patterns.BasicPatterns;

import java.util.Scanner;

public class halfpyramid {
    public static void main(String[] args) {
        Scanner Sc = new  Scanner(System.in);
        int n = Sc.nextInt();
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(" "+ j);
            }
            System.out.println();
        }
    }
}