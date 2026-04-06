package LEETCODE.BitManupulation.medium;

import java.util.Scanner;

public class S1_Leetocode_MinBitFlipToConvertNum {
    private static int minbitflip(int start , int goal){
        int num = start ^ goal;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((num & (1 << i)) != 0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int start  = sc.nextInt();
        int goal = sc.nextInt();

        minbitflip(start, goal);
    }
}
