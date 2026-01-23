package LEETCODE.BinarySearch;
import java.util.Scanner;


public class ArrayInp {

    public static int[] takeArrayInput() {
        Scanner sc = new Scanner(System.in);

        // System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        // System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target  = sc.nextInt();

        return arr;
    }



}
