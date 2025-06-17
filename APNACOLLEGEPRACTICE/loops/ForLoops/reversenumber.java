package loops.ForLoops;

import java.util.Scanner;

public class reversenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number you want to reverse ");
        int number = sc.nextInt();
        
        while (number>0) {
            
            int lastDigit =  number % 10;
            System.out.print(lastDigit);
            number=  number /10;
        }
       System.out.print(number);
    }
    
}
