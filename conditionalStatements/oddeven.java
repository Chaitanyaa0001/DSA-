package conditionalStatements;

import java.util.Scanner;

public class oddeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter The Value OF n: ");
        long n = sc.nextLong();

        if ( n % 2 == 0){
            System.out.println("The Number Is even");
        }else if ( !(n % 2== 0) ) {
            System.out.println("The Number IS odd");
        }else{
            System.out.println("error");
        }
        sc.close();

    }
    
}
