package LEETCODE.BinarySearch.BinaryOnAnswers;

import java.util.Scanner;

import LEETCODE.BinarySearch.ArrayInp;

public class S3_Leetcode_KokoBanana {

    public static int totalHours(int[] piles, int speed){
        int totalH = 0;
        for(int p : piles){
            totalH +=  (int) Math.ceil((double)p / speed);
        }
        return totalH;
    }

    public static int brute_force(int[]piles, int h){
        int n = piles.length;
        int maxelementinarray = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            if(piles[i] > maxelementinarray){
                maxelementinarray =  piles[i];
            }
        }
        
        for(int  i = 0; i <= maxelementinarray; i++ ){
            if(totalHours(piles, i) <= h){
                return i;
            }
        }
        return -1;
    }

    public static int optimal(int[] piles, int h){
        
        return-1;
    }

    public static void main(String[] args) {
        int [] piles = ArrayInp.takeArrayInput();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
}
