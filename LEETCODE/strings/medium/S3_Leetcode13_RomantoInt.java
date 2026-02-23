package LEETCODE.strings.medium;

import java.util.HashMap;
import java.util.Scanner;

public class S3_Leetcode13_RomantoInt {
    // Symbol          Value
        // I             1
        // V             5
        // X             10
        // L             50
        // C             100
        // D             500
        // M             1000
    public static int conversion(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M',1000);
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++){
            int current = map.get(s.charAt(i));
            if(i < s.length() - 1 && current <  map.get(s.charAt(i+1))){
                sum -= current;
            }else{
                sum += current;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
    }
}
