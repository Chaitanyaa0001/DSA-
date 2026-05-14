package LEETCODE.SlidingWindow;

import java.util.Scanner;

public class S8_LongestRepeatingCharacterReplacement {
    private static int bruteforce(String s, int k){
        int n = s.length();
        int maxlen = 0; 
        int maxfreq = 0;

        for(int i = 0; i < n; i++){
            int[] hash  = new int[n];
            for(int j = i; j < n; j++){
                hash[s.charAt(j)]++;
                maxfreq = Math.max(maxfreq, hash[s.charAt(j)]);
                int changes  = maxfreq - (j-i+1);
                if(changes <= k){
                    maxlen = Math.max(maxlen,(j-i+1));
                }
            }
        }
        return maxlen;
    }
    private static int betterApproch(String s , int k){
        int n = s.length();
        int l = 0; int r = 0;
        int maxlen = 0, maxfreq = 0;
        int[] hash = new int[n];

        while (r < n) {
            char ch = s.charAt(r);
            hash[ch - 'A']++;
            maxfreq = Math.max(maxfreq, r-l+1);

            // shrink 
            while ((r-l+1) - maxfreq > k) {
                hash[ch - 'A']--;
                l++;
            }
            maxlen = Math.max((r-l+1), maxlen);
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        bruteforce(s, k);
        betterApproch(s, k);
        
    }
}