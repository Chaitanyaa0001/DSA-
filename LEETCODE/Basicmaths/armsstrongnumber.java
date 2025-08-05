package LEETCODE.Basicmaths;

import java.util.Scanner;

public class armsstrongnumber {
    public static boolean isArmstriong(int n){
        int power = (int)Math.log10(n) + 1;
        int num = n;
        int armnumber = 0;
        while (num>0) {
            int lastdigit = num % 10;
            armnumber = armnumber  + (int)Math.pow(lastdigit,power);
            num /=10;
        }
        return armnumber == n ;
 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the value of n ");
        int n = sc.nextInt();

        boolean result = isArmstriong(n);
        System.out.println(result);
    }
}


