package APNACOLLEGEPRACTICE.conditionalStatements.switchproblems;

import java.util.Scanner;

public class weakdays {
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);

    System.out.println("ENter the number between 1-7");
    int weekday = sc.nextInt();

    switch (weekday) {
        case 1:System.out.println("Monday");
            break;
        case 2 :System.out.println("Tuesday");   
            break;
        case 3 :System.out.println("Wednesday");   
            break;      
        case 4 :System.out.println("Thursday");   
            break;     
        case 5 :System.out.println("Friday");   
            break; 
        case 6 :System.out.println("Saturday");   
            break;     
        case 7 : System.out.println("Sunday");  
            break;  
        default: System.out.println("you have entered the nmber which is more than 7 .Retry");
        break;
    }
        
    }


}
