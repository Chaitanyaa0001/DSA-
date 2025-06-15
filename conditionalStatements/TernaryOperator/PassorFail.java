package conditionalStatements.TernaryOperator;

import java.util.Scanner;

public class PassorFail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Marks Of A Student ");
        int marks = sc.nextInt();

        String pass = marks >33 ? "pass": "fail";

        System.out.println(pass);
    }

   
}
