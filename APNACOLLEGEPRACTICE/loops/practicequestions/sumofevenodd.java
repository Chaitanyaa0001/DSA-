package APNACOLLEGEPRACTICE.loops.practicequestions;
 import java.util.*;
import java.math.*;;
public class sumofevenodd {

    public static void main(String[] args) {
        int counter = 0;
        int number ;
        int oddsum = 0;
        int evensum = 0;                  
                                          
        
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("enter the number ");
            number = sc.nextInt();
            if ( number % 2==0) {
                evensum += number;    
            }else{
                oddsum += number;
            }
            System.out.println("do you want to continue ?if yes press 1 or 0 for no ");

            counter = sc.nextInt();
        } while ( counter ==1);

        
        System.out.println("The sum of even number :" + evensum);
        System.out.println("the sum of odd number :" + oddsum );

    }
}



