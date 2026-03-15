package LEETCODE.recursionMain.Problems;

import java.util.Scanner;

public class S_NtoOne {
    private static void f(int n){
        if(n == 0){
            return ;
        }
        System.out.println(n);
        f(n -1);
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
        // 5
        // 4
        // 3
        // 2
        // 1
    }
}
