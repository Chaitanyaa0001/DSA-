package LEETCODE.recursionBasic;

import java.util.Scanner;

public class factorial {

    public static int factoriall(int n){
        if(n == 0){
            return 1;
        }
        return n * factoriall(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vale of factorial");
        int n = sc.nextInt();
        int result = factoriall(n);
        System.out.println(result);
    }
};
