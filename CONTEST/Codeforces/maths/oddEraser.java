package CONTEST.Codeforces.maths;

import java.util.Scanner;

/**
 * oddEraser
 */
public class oddEraser {
    private static int gcd(int a, int b){
        while (b != 0) {
            int res = a % b;
            a = b;
            b = res;
        }
        return a;
    }

    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while (t --> 0) {
            int m = sc.nextInt();
            int arr[] = new int[m];
                        
            for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
            }
           int ans =  gcd(arr[0], arr[m-1]);
           System.out.println(ans);
        }
        sc.close();
    }
}