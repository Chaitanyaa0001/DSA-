package Functions.basicques;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class isPrime{

// to check prime 
    public static boolean ISPRIME( int n){

        if(n == 2 ){return true;}
        for (int i = 2 ;i <= Math.sqrt(n);i++){
            if (n % i == 0 ){
                return false;

            }
        }
        return true;
    }
     public static void rangeprime(int n ){
        for (int i = 2 ;i<=n ;i++){
            if (ISPRIME(i)){
                System.out.print(i);
            };
            System.out.print(" ");
        };
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number to check weather it is prime or not :");
        int n = sc.nextInt();
        rangeprime(n);
    }
    
}
