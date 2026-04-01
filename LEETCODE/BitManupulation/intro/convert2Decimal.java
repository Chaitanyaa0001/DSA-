package LEETCODE.BitManupulation.intro;

import java.util.Scanner;

public class convert2Decimal {
    private static int converttodecimal(String x){
        // 1101
        // 1 * 2 pow 0 + 0 * 2 pow 1 + ......
        int len = x.length();
        int num = 0;
        int pow = 1;
        for(int i = len -1; i >= 0; i++){
            if(x.charAt(i) == 1){
                num +=  pow;
            }
            pow *= 2;
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String x =  sc.nextLine();

    }
}


