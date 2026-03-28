package LEETCODE.patterns.BasicPatterns;

import java.util.Scanner;

public class S17ques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            char alphabet = 'A';
            int breakpoint = (2*i+1) / 2;
            
            // space 
            for(int j = 0; j <= n-i-1; j++){
                System.out.print(" ");
            }
               
            // char 
            for(int j = 0; j < 2*i+1 ; j++){
                System.out.print(alphabet);
                if(  j <  breakpoint){
                    alphabet++;
                }else{
                    alphabet--;
                }
            }

             for(int j = 0; j <= n-i-1; j++){
                System.out.print(" ");
            }
            System.out.println(" ");
            
        }
    }
}
