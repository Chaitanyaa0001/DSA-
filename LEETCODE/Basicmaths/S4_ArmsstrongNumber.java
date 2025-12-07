package LEETCODE.Basicmaths;

import java.util.Scanner;

// in armstrong number if we take 
//  321 then the cube of the 3 , 2 and 1  should be equal to the 321 then it will be armstrong number 


public class S4_ArmsstrongNumber {
    public static boolean isArmstriong(int n){
        int number = 0;
        int pow = (int) Math.log10(n) +1;
        int original = n;
        // if number if -ve 
        if(n < 0 ){
            return false;
        }
        // if number is 0 as 0 is armstrong number 
        if(n == 0){
            return true;
        }
        // to check weather number is armstrong or not 
        while (n > 0) {
            int digit = n %10;
            number = number + (int) Math.pow(digit, pow);
            n = n /10;
        }
        if(original == number){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n ");
        int n = sc.nextInt();
        boolean result = isArmstriong(n);
        System.out.println(result);
    }
}


