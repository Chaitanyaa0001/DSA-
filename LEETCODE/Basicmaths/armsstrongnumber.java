package LEETCODE.Basicmaths;

import java.util.Scanner;

public class armsstrongnumber {
    public static boolean isArmstriong(int n){
        int num = n;
        int sum = 0;
        int digits = String.valueOf(num).length();

        while (num > 0 ){
            int lastdigit = num % 10;
            sum += Math.pow(lastdigit,digits );
            n/= 10;
            return true;
        }
        return false ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the value of n ");
        int n = sc.nextInt();

         boolean result = isArmstriong(n);
        System.out.println(result);
    }
}


