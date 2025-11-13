package Functions.Conversion;

import java.util.Scanner;

public class DecimaltoBinary {
    public static int decimalToBinary(int n ){
        int number = 0;
        int pow = 0;

        while (n > 0) {
            int reminder = n % 2; 
            number = number + ( reminder * (int) Math.pow(10,pow));
            n = n/2;
            pow ++;

        }
        return number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number which you wannt to convert to binary:");
        int n = sc.nextInt();
       
        System.out.println(decimalToBinary(n));
        
    }
    
}
