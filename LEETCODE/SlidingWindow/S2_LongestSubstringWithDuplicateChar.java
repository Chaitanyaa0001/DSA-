package LEETCODE.SlidingWindow;

import java.util.Scanner;

public class S2_LongestSubstringWithDuplicateChar {
    private static int BruteForce(String s){
        int n = s.length();
        int maxlen = 0;
        // a b c a b c b b
        for(int i = 0; i < n; i++){
            int hash[] = new int[256];
            for(int j = 0; j < n; i++){
                if(hash[s.charAt(i)] == 1){
                    break;
                }
                hash[s.charAt(i)] = 1;
                int len = j - i + 1;
                maxlen = Math.max(maxlen,len);
            }
        }
        return maxlen;
    }

    private static int optimal(String s){
        int n = s.length();
        int hash[] = new int[256];

        // int l = 0; int r = 0; int len = 0; int maxlen = 0;

        // while (r < n) {

        // }
        // return maxlen;
    }

    public static void main(String[] args) {
        // Given a string s, find the length of the longest substring without duplicate characters.
        // abcabcbb 
       Scanner sc = new  Scanner (System.in);
       String s = sc.nextLine();
       BruteForce(s);
       optimal(s);

    }
}
