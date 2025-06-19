package APNACOLLEGEPRACTICE.conditionalStatements.BasicifElse;

import java.util.Scanner;

public class incometaxcalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Inocme :");
        long income = sc.nextLong();

        if(income < 500000){
            System.out.println("Total Tax 0%");

        }else if (income >500000 && income < 1000000){
            System.out.println("Total Tax 20%");
        }else if (income > 1000000){
            System.out.println("Total Tax 30%");
        }
        else{
            System.out.println("error");
        }
    }
    
}
