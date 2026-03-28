package LEETCODE.patterns.BasicPatterns;

import java.util.Scanner;

public class S10ques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i <= 2 * n-1; i++){
            int star = i;
            if(star > n) {
                star =  2 * n-i;
            }
            for(int j = 0; j < star; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
