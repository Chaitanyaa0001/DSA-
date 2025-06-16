package Functions.basicques;

import java.util.Scanner;

import loops.practicequestions.factroial;

public class bionomial {
    public static long factorial(  long number){
        long f = 1;
        for (int i = 1;i <=number;i++){
            f= f*i;
            System.out.println( "The factorial function " +f);
        }
        return number ;
    }
    public static long  bionomail ( int n, int r){

        if (r>n){
            System.out.println("r should not ");
        }
        long fn = factorial(n);
        long fr = factorial(r);
        long NmR = factorial(n-r);

        long BIONOMIAL = 1;
        BIONOMIAL =  fn / (fr * NmR); 

        return BIONOMIAL;

        }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the vauue of n to calculate the bionomial :");
        int n = sc.nextInt();
        System.out.println("enter the vauue of r to calculate the bionomial :");
        int r = sc.nextInt();

        bionomail(n, r);

       
        
    }
    
}
