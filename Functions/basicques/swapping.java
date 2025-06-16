package Functions.basicques;

import java.util.Scanner;

public class swapping {

    public static void swapthenumber(int a ,int b){
        int temp = b;
        b = a;
        a = temp;
        
        System.out.println("the value after swapping  A:" + a);
        System.out.println("the value after swapping  B:" + b);

        
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("enter the value of A:");
        int a = sc.nextInt();
        System.out.println("enter the value of B:");
        int b = sc.nextInt();

        swapthenumber(a, b);
        System.out.println("Original A in main: " + a);
        System.out.println("Original B in main: " + b);


    }
    
}
