package LEETCODE.strings.easy;

import java.util.Arrays;
import java.util.Scanner;

public class S4_Leetcode14_LongestCommonPredix {
    public static String  bruteforce( String[] strs){
        int n = strs.length;

        String first  = strs[0];
        for(int i = 0; i < first.length(); i++){
            // flower 
            //  i 
            // flow
            // flight 
            char c = first.charAt(i);
            for(int j = 1; j < n; j++){
                if(strs[j].charAt(i) != c || i >= strs[i].length()){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    public static String optimal(String[] strs){
        int n = strs.length;
        Arrays.sort(strs);
        // flower 
        // i 
        // flight
        int i = 0;
        String first = strs[0];
        String last = strs[n -1];
        while (i < first.length() && i < last.length()) {
            if(first.charAt(i) != last.charAt(i)){
                break;
            }
            i++;
        }
        return first.substring(0, i);
    }
    public static void main(String[] args) {
        Scanner SC  = new Scanner(System.in);
        String strs[] = {"flower","flow","flight"};
    }
}
