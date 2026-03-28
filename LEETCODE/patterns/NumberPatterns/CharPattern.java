package LEETCODE.patterns.NumberPatterns;

import java.util.*;

public class CharPattern {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char aplhabet  = 'A';

        System.out.println("enter the number ");
        int n = sc.nextInt();

        for(int i = 1;i <=n;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(aplhabet);
                aplhabet++;
            }
            System.out.println();

        }
    }
}
