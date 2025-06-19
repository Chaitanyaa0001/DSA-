package APNACOLLEGEPRACTICE.Functions.Conversion;

import java.util.Scanner;

public class BinarytoDecimal {

    public static void GetbinarytoDecimal(int n ){

        int num = 0;
        int lastdigit ;
        int power = 0;

        while(n>0){ 

            lastdigit = n%10;
             num = num + (lastdigit * (int) Math.pow(2, power));
            n = n/10;
            power++;
            
        }
        System.out.println("the decimal of " + n + "is " + num);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number  that you want to convert it into Decimal :");
        int n = sc.nextInt();

        GetbinarytoDecimal(n);

        
    }
    
}
