package LEETCODE.arrays.Hard;

import java.util.Scanner;


// in pascal triangle when we inter the correct row and col then it will print the exat number or element whihc is present at that index 
public class S1PascalTriangle {
    // n factorial 
    public static int factorial(int n){
        int factorial = 1;
        for(int i = 0; i < n; i++){
            factorial *= n-i;
        }
        return factorial;
    }
    

    public static int  enterrowandcolnumbertoidentifynumber(int row,int col){
        // bruteforce
        // find factorial 

        int n = factorial(row);
        int r =factorial(col);
        int nMr = factorial(row-col);
        return n / (r *(nMr));
    }

    public static int optimalapproch(int row,int col){
        int ans = 1;
        for(int i = 0; i < col; i++ ){
            ans = ans * (row-i) ;
            ans = ans / (i+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        // int result = enterrowandcolnumbertoidentifynumber(row-1, col-1);
        // System.out.println(result);


        int resultt = optimalapproch(row-1, col-1);
        System.out.println(resultt);
    }   
}
