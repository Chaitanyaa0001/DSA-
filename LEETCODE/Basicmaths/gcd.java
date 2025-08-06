package LEETCODE.Basicmaths;

import java.util.Scanner;

public class gcd {
    public static void ToCalGcd(int N1, int N2){
        for(int i = 1; i< N1; i++){
            if(N1 % i == 0){
                System.out.println(i);
            }
        }
       for(int j = 1; j< N2; j++){
            if(N2 % j == 0){
                System.out.println(j);
            }
        }
        
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of N1:");
        int N1 = sc.nextInt();
        System.out.println("Enter the value of N2: ");
        int N2 = sc.nextInt();

        ToCalGcd(N1,N2);
    }
}
