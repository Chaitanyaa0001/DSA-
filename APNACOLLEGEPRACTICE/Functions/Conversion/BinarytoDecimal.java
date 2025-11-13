package Functions.Conversion;

import java.util.Scanner;

import A2Darrays.search;

public class BinarytoDecimal {
   
    public static int bintodecimal(int n) {
        int pow = 0;
        int number = 0;
        while(n > 0){
            int lastdigit = n % 10;
            number = number +   lastdigit * (int) Math.pow(2, pow);
            n = n / 10;
            pow ++;
        }
        return number;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();
        bintodecimal(n);
        System.out.println(bintodecimal(n));
        // BinToDec(n);
        
    }
    
}
