package LEETCODE.strings.medium;

import java.util.Scanner;

public class S2_Leetcode1614_MaxNestingDepthOfParenthesis {
    public static int nestingmax(String s){
        int n = s.length();
        int balance = 0;
        int max = 0;

        for(int i = 0 ; i < n; i++){
            if(s.charAt(i) == '('){
                balance ++;
                if(balance > max){
                    max = balance;
                }
            }else if(s.charAt(i) == ')'){
                balance --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
    }
}