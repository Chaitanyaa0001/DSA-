package LEETCODE.strings.medium;

import java.util.Scanner;

public class S4_LongestPalindromeSubstring {
    public static Boolean checkPalindromeHelper(String sub){
        int n = sub.length();
        int i = 0;
        int j = n -1;
        while (i < j) {
            if(sub.charAt(i) != sub.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    // brute 
    public static String bruteforce(String s){
        int n = s.length();
        String ans = "";
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                String sub = s.substring(i, j+1);
                if(checkPalindromeHelper(sub) && sub.length() > ans.length()){
                    ans =  sub;
                }
            }
        }
        return ans;
    }
    // better 
    // expand through centre 
    public static String betterApproch(String s){
        int n = s.length();
        int max = 1;
        int start  = 0, end  = 0; 
        for(int i = 0; i < n; i++){
            // odd
            int len1 = calculatelen(s,i,i);
            // even 
            int len2 = calculatelen(s,i,i+1);
            max = Math.max(len1,len2);
            if( end - start  <  max ){
                start = i - (max -1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end+1);
    }
    public static int calculatelen(String s,int i, int j){
            while ((i >= 0 && j < s.length()) &&  s.charAt(i) == s.charAt(j)) {
                i--; j++;
            }
        return  j - i - 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
    }   
}
