package Functions.basicques;

import java.util.Scanner;

class Binomial {


    public static int  factorial (int n ){
        int f = 1;
        for(int i = 1; i<=n; i++){
            f = f * i; 
        }
        return f;
    }
    public static int CalculateBinomial(int n , int r){
        int Fn = factorial(n);
        int Fr = factorial(r);
        int NmR = factorial(n-r);

        int BinomialCoff = Fn / (Fr * NmR) ;
        return BinomialCoff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.print("Enter the value of r: ");
        int r = sc.nextInt();

       System.out.println(CalculateBinomial(n, r)); 

      
    }
}
