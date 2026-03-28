package LEETCODE.patterns.BasicPatterns;

import java.util.Scanner;

public class S15ques{
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        int n = sc.nextInt();

        
        for(int i = 0; i <= n-1; i++){
            char alphabet  = 'A';
            for(int j = 0; j <= n-i-1; j++){
                System.out.print(alphabet);    
                alphabet++; 
            }
            System.out.println("");
        }

    }   
}
