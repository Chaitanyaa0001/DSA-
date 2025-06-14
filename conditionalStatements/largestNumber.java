package conditionalStatements;

import java.util.*;

public class largestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number A:");
        int A = sc.nextInt();

        System.out.println("enter the number B");
        int B = sc.nextInt();

        if(A>B){
            System.out.println("The NUmber A Is Greater:"+ A);
        }else if (B>A){
            System.out.println("THe Number B is Greater" + B);
        }else  if(A==B) {
            System.out.println("Both Are Equal ");
        }else {
            System.out.println("error");
        }
        
    }

}