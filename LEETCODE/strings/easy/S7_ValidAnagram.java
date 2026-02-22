package LEETCODE.strings.easy;

import java.util.Scanner;

public class S7_ValidAnagram {
    public static Boolean validanagram(String s, String t){
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i : arr){
            if(i != 0){
                return false ;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();
        String t = sc.nextLine();
    }
}
