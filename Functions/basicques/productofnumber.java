package Functions.basicques;

import java.util.Scanner;

public class productofnumber {

    public static int multiply(int a ,int b ){
        int product = a*b;
        System.out.println( "the product of a nd b is :"+product);

        return product;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the value of A:");
        int a = sc.nextInt();

        System.out.println("Enter the value of B:");
        int b = sc.nextInt();

        multiply(a, b);

        
        
    }
    
}
