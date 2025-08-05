package Functions.practicequestions;

import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class counts {

    public static void TOcheckcounts(int n ){
        int digits = (int)Math.log10(n) + 1;
        System.out.println(digits);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value");
        int n = sc.nextInt();

        TOcheckcounts(n);
    }
    
}
