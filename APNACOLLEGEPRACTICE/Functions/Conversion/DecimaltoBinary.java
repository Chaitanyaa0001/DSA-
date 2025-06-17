package Functions.Conversion;

import java.util.Scanner;

import patterns.BasicPatterns.starPattern;

public class DecimaltoBinary {

    public static void GetdecimaltoBinary(int n){
        int num = 0 ;
        int power =0;

        while (n>0){
             int remender = n %2;
             num = num + ( remender *  (int )Math.pow(10, power));
             n = n/2;
             power++;
        }
        System.out.println("the binary number for " + n + "is :" + num) ;
        
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number which you wannt to convert to binary:");
        int n = sc.nextInt();

        GetdecimaltoBinary(n);
        
    }
    
}
