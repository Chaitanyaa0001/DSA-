package APNACOLLEGEPRACTICE.Functions.practicequestions;

import java.util.Scanner;

public class isEvencheck {

    public static boolean isEven(int n){
        if (n % 2== 0){
            return true;
        }
        
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of N");
        int n = sc.nextInt();

         boolean result = isEven(n);
        System.out.println(" for prime True And For odd False :" + result);  
        
    }
    
}
