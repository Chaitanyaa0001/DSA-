package conditionalStatements.BasicifElse;

import java.util.Scanner;

public class positivenegative {
    private static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Number N");
        int n = sc.nextInt();

        if(n <0){
            System.out.println("the number is negative ");
        }
        else {
            System.out.println("the number is positive");
        }

    }
    
}
