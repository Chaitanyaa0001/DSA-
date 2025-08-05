package Functions.Conversion;

import java.util.Scanner;

public class BinarytoDecimal {
    public static void BinToDec(int n ){
        int pow = 0;
        int decimalNumber = 0;
        while (n>0) {
            int lastDigit = n % 10;
            decimalNumber = decimalNumber + (int)(lastDigit * Math.pow(2, pow));
            pow ++;
            n /=10;
        }
        System.out.println("The binary number"  +  n  +  "is ocnverted into decimal :" +  decimalNumber );
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        BinToDec(n);
        
    }
    
}
