package LEETCODE.patterns.BasicPatterns;

import java.util.Scanner;

public class S16ques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        char alphabet = 'A';
        for(int i = 0; i <= n; i++){
            if ( i == 0){
                alphabet = 'A';
            }else{
                alphabet++;
            }
            for(int j = 0; j <= i; j++){
                System.out.print(alphabet);
            }
            System.out.println("");
        }

    }
}
