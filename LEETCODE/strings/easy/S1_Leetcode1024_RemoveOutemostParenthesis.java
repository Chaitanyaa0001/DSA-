package LEETCODE.strings.easy;

import java.util.Scanner;

public class S1_Leetcode1024_RemoveOutemostParenthesis {
    public static String removeOuterParenthesis(String s){
        StringBuilder ans = new StringBuilder();
        int balance = 0; 
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                if(balance > 0){
                    ans.append(s.charAt(i));
                }
                balance ++;
            }else{
                balance--;
                if(balance > 0){
                    ans.append(s.charAt(i));
                    
                }
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        //         A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
        // For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
        // A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
        // Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
        // Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

    }
}
