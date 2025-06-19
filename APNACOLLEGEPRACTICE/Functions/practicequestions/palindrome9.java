package APNACOLLEGEPRACTICE.Functions.practicequestions;
import java.util.Scanner;

public class palindrome9 {
    public static int reverse(int n){
        int reversenum = 0;
        int  lastdigit = n%10;
        reversenum =  reversenum * 10 + lastdigit;
        return reversenum;
    }
    public static  Boolean checkPalindrome( int n){
        int reversednum  =  reverse(n);
        if (n == reversednum ){
            return true;
        }return false;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to check the palindrome :");
        int n = sc.nextInt();
        boolean result =   checkPalindrome(n);
        System.out.println("True for plaindrome and Flase for not Plandrome " + result);
    }
};


