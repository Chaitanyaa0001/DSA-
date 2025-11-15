package Functions.practicequestions;

import java.util.Scanner;

public class sumofintegers {
    public static  int  integer( int n ){
        int sum = 0;
        
        while (n>0) {
            int lastdigit = n%10;
            n = n/10;
            sum = sum + lastdigit;
        }
        n = n/10;
        return sum ;
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer :");
        int n  =  sc.nextInt();
        int result  = integer(n);
        System.out.println("The sum of a integer is: " + result);
    };
};
