package LEETCODE.arrays.Hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

        // int this we need to print the whole N row whihc is the value inserted by the user 
        // if user enters   5 then the  value should be 1 4 6 4 1
public class S1_leetcode119PascalTriangle2 {
        // jitna n ki value hai utne hi elements print krne hai 


        public static int helperfunction(int row,int col){
                int ans = 1;
            for(int i = 0; i < col; i++ ){
                ans = ans * (row-i) ;
                ans = ans / (i+1);
            }
            return ans;
        }
        public static List<Integer> getrow(int row){
            ArrayList<Integer> list = new ArrayList<>();

            int res = 1;
            for(int i = 1; i <= row; i++){
                res =  helperfunction(row-1, i-1);
                list.add(res);
            } 
            return list;
        }

        public static List<Integer> optimalapproch(int row){
            ArrayList<Integer> ar = new ArrayList<>();

            for(int i = 0; i < row; i++){
                
            }
            return ar;
        }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        List l = getrow(row);
        System.out.println(l);
    }
}