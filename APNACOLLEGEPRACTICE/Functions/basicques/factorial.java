package Functions.basicques;

import java.util.Scanner;

public class factorial {

    public static long factorial (long n){
        long f =1;

        for (int i =1;i<=n;i++){
            f = f*i;
        }
        return f;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tge value of n:");
        long n = sc.nextInt();
         
        factorial(n);
        System.out.println(factorial(n));
        
    }
    
}
