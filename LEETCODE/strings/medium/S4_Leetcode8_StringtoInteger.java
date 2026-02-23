package LEETCODE.strings.medium;

import java.util.Scanner;
// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
// The algorithm for myAtoi(string s) is as follows:
// Whitespace: Ignore any leading whitespace (" ").
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
// Return the integer as the final result.

import A2Darrays.number7s;

public class S4_Leetcode8_StringtoInteger {
    public static int myAtoi(String s){
        int n = s.length();
        int i = 0;
        int sign = 1;
        int num = 0;
        // white space 
        while (i < n && s.charAt(i) == ' ') {
            i++;
        };
        // sign 
        if( i < n &&  s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else{
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            // string into digit  5 -> 5
            int digit =  s.charAt(i) - '0';
            // overflow 
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return num * sign;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
    }
}
