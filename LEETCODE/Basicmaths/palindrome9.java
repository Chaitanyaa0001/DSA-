package LEETCODE.Basicmaths;

public class palindrome9
   {

    // mainleetcode 
    public static boolean isPalindrome(int x) {
        int lastDigit = 0;
        int reverseNum = 0;
        int num = x;

        if (num < 0) return false;

        while (num > 0) {
            lastDigit = num % 10;
            reverseNum = (reverseNum * 10) + lastDigit;
            num = num / 10;
        }

        return x == reverseNum;
    }
    // Main method to run in VS Code
    public static void main(String[] args) {
        int number = 121; // You can change this to test other numbers

        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }

    
}
