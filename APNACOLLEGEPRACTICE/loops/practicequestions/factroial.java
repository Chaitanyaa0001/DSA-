package APNACOLLEGEPRACTICE.loops.practicequestions;

import java.util.Scanner;

public class factroial {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("enter the number ");
        int n = sc.nextInt();
        int factorial = 1;

        for (int i =1; i <= n ; i++){
            factorial  = factorial *i;
            
        }
        System.out.println("factorial of this number " + factorial);
    }
    
}
