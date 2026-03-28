package conditionalStatements.BasicifElse;

import java.util.Scanner;

public class largest3numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Value of A");
        int A = sc.nextInt();

         System.out.println("Enter The Value of B");
        int B = sc.nextInt();

         System.out.println("Enter The Value of C");
        int C = sc.nextInt();

        if(A>B && A>C){
            System.out.println("A is Greater");
        }else if (B>C){
            System.out.println("B is Greater Than C");
        }else {
            System.out.println("C is greater " );
        }
    }
    
}
