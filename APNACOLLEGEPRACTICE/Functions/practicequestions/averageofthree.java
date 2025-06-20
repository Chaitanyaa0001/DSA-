package Functions.practicequestions;

import java.util.Scanner;

public class averageofthree {

    public static void average(int a, int b, int c){
        int sum  = 0 ;
        sum = (a+b+c) / 3 ;
        System.out.println("The average of sum is :" + sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of A");
        int a = sc.nextInt();
        System.out.println("Enter the value of B");
        int b = sc.nextInt();
        System.out.println("Enter the value of C:");
        int c = sc.nextInt();
        
        average(a,b,c);
    }
    
}
