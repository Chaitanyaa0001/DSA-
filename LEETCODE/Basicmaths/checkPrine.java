package LEETCODE.Basicmaths;

import java.util.Scanner;

public class checkPrine {

    public static Boolean isprime(int n){
        if(n<=1) return false;
        if (n == 2) return true;
        if(n %2 == 0) return false;
        for (int i = 3;i<= Math.sqrt(n) ;i++){
            if(n % i == 0){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the value of n");
        int n = sc.nextInt();

         boolean result = isprime(n);

         System.out.println(result);
        
    }
    
}