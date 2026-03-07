package loops.practicequestions;

import java.util.Scanner;

public class table {
    private static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the number to print the table ");
        int number = sc.nextInt();
        int table =0;

        for (int i = 0 ;i <= 20; i++){
            table = number*i;
            System.out.println( table  );
        }
    }
};
