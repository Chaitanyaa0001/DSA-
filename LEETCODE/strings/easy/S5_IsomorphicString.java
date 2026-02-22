package LEETCODE.strings.easy;

import java.util.HashMap;
import java.util.Scanner;

public class S5_IsomorphicString {
    public static Boolean slightslowapproch(String s, String t){
        // Paper 
        // title 

        if ( s.length() != t.length()){
            return false;
        }

        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char Soriginal = s.charAt(i); // p
            char Treplace = t.charAt(i);// t
            // agar mera hashmap mei value nhi hai  
            if(!map.containsKey(Soriginal)){

                if(!map.containsValue(Treplace)){
                    map.put(Soriginal, Treplace);
                }else{
                    return false;
                }
                // or agar mera hashmap mei value 
            }else{
                char  maped = map.get(Soriginal);
                if(maped != Treplace){
                    return false ;
                }

            }
        }
      return true;
    }

    public static Boolean optimalApproch(String s, String t){
        int n = s.length();
        HashMap<Character,Character>  SmT = new HashMap<>();
        HashMap<Character,Character>  Tms  = new HashMap<>();

        for(int i = 0  ; i < n; i++){

            char char1 = s.charAt(i);
            char  char2 = t.charAt(i);
            //  s -> t
            if(SmT.containsKey(char1)){
                if(SmT.get(char1) != char2){
                    return false;
                }
            }else{
                SmT.put(char1, char2);
            }

            if(Tms.containsKey(char2)){
                if(Tms.get(char2) != char1){
                    return false;
                }
            }else{
                Tms.put(char2, char1);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
    }
}
