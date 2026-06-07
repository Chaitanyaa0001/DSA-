package LEETCODE.backtracking.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L17_LetterCombinationOfPhone {
    
    public static List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0,digits,ans,sb,map);
        return ans;
    }

    private static void dfs(int index, String digits, List<String> ans, StringBuilder sb, HashMap<Character,String> map){

        if(index == digits.length()){
            ans.add(sb.toString());
            return ;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for(int i = 0; i < letters.length(); i++){

            sb.append(letters.charAt(i));
            dfs(index+1,digits,ans,sb,map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    
 public static void main(String[] args) {

    String digits = "23";
    letterCombinations(digits);
    
    
 }   
}
