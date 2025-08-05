package Functions.Conversion;

import java.util.Scanner;

public class DecimaltoBinary {
    public static void DecToBin(int n){
        int Binarynum = 0;
        int power = 0;
        if (n<0)  return ;
        while (n > 0) {
            int reminder = n % 2;
            Binarynum =  Binarynum + (int)(reminder * Math.pow(10, power)) ; 
            power++;
            n = n/2;
        }
        System.out.println("the number "+ n + "which you want to convert into binary is " + Binarynum );
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the number which you wannt to convert to binary:");
        int n = sc.nextInt();
        DecToBin(n);
        
    }
    
}
