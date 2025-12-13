package LEETCODE.Basicmaths;

import java.util.Scanner;

public class S3_Leetcode_9quesPalindrome{
    public static boolean CheckIfaNumberIsPalindrome(int n){
        int checkNum = 0;
        while (n != 0) {
            int digit = n % 10;
            checkNum = checkNum * 10 +  digit;
            n = n / 10;
        }
        if(checkNum == n){
            return true;
        }else{
            return false;
        }
    }
    // we can also solve it optimal approch as by only chcking the half of the number  and compare 
    // in odd middle element does not matters we will remove it 
    public static boolean OptimalApproch(int n){
        if(n < 0 ){
            return false;
        }
        int check = 0;
        while (n > check) {
            check = check * 10 + (n % 10);
            n = n/10;
        }
        if(check == n || n == check/10){
            return true;
        }else{
            return false;
        }

    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // System.out.println(CheckIfaNumberIsPalindrome(n));
        System.out.println(OptimalApproch(n));
    }

    
}
