package LEETCODE.Basicmaths;

// to calculate the digits of  a number  which the user inputs
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class S1quesCounts {

    public static long returnNumberOfCounts(long n) {
        long count = 0;
        if(n == 0){
            return 1;
        }
        while(n > 0){
            long lastdigit = n % 10;
            n = n/10;
            count ++;
        }
        return count;
    }

    public static int returnNumberOfCountsByLog(int n){
        int  digits = (int) Math.log10(n) +1;
        return  digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value");
        // long n = sc.nextLong();
        int n = sc.nextInt();

        // long result = returnNumberOfCounts(n);
        // System.out.println(result);
        int result =returnNumberOfCountsByLog(n);
        System.out.println(result);
    }
    
}
