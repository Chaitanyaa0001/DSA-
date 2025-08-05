// it is used to fine the all the divisors of a number 


package LEETCODE.Basicmaths;

import java.util.Scanner;

public class alldivisors {
    public static void divisors(int n ){
        for (int i = 1; i<= n; i++){
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        divisors(n);
    }
}
