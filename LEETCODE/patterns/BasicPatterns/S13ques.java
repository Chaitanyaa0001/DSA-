package LEETCODE.patterns.BasicPatterns;

import java.util.Scanner;

public class S13ques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = 1;
        for(int i = 0; i <= n-1;i++){
            for(int j = 0; j<=i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println("");
        }

    }
}
