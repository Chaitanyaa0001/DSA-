package LEETCODE.BitManupulation.intro;
import java.util.Scanner;

/**
 * convert2Decimal
 */
public class convert2Decimal {

    private static int convertToDecimal(String binaryString) {
        int  number  = 0;
        int power = 0;

        for (int i =  binaryString.length() - 1; i >= 0; i--) {
            int bit = binaryString.charAt(i) - '0';
            number += bit * ((int) Math.pow(2, power));
            power++;
        }
        
        return number;
    }
    private static int strivermethod(String s){

        int number = 0; int power = 0;

        for(int i  = s.length() - 1; i >= 0; i--){
            int bit = s.charAt(i) - '0';

            if(bit == 1){
                number += (1 << power);
            }
            power++;
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String binaryString = scanner.nextLine();
        
        // System.out.println(convertToDecimal(binaryString));
        System.out.println(strivermethod(binaryString));
    }
    
}