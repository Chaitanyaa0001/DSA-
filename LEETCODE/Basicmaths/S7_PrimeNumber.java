package LEETCODE.Basicmaths;

import java.util.Scanner;

public class S7_PrimeNumber {

    public static Boolean isprime(int n){
        int cnt = 0;
        if(n == 2){
            return true;
        }
        if(n == 2){
            return true;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                cnt++;
                if(n/i != i){
                    cnt++;
                }
            }
        }
        return cnt == 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the value of n");
        int n = sc.nextInt();

        boolean result = isprime(n);

         System.out.println(result);
        
    }
    
}