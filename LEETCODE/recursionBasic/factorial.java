package LEETCODE.recursionBasic;

import java.util.Scanner;

public class factorial {
    public static int factoriall(int a,int n){
        if(a>n) return 1;
        System.out.println(a);
        return  a * factoriall(a +1, n);
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the vale of factorial");
        int n = sc.nextInt();

        int result = factoriall(1,n);
        System.out.println(result);
    }
}
