package APNACOLLEGEPRACTICE.loops.ForLoops;

import java.util.Scanner;

public class reversegivenNo {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the number you want to reverse :");
    int n = sc.nextInt();
    int reverse = 0;

    while(n>0){
        int lastDigit = n %10;
         reverse = (reverse *10) + lastDigit;
         n/=10;
        //  System.out.print(reverse);
    }
    System.out.println("reversed number :" + reverse );
    }
    
};
