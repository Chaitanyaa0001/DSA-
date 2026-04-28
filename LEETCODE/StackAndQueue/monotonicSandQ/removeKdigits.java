package LEETCODE.StackAndQueue.monotonicSandQ;

import java.util.Scanner;
import java.util.Stack;

public class removeKdigits {
    public static  String removeKdigits(String s, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int nn = s.charAt(i) - '0';
            while(!stack.isEmpty() && k > 0 && (stack.peek() - '0') > nn  ){
                stack.pop();
                k--;
            }
            stack.push(s.charAt(i));
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        int i = 0;
        while(i < sb.length() && sb.charAt(i) == '0'){
            i++;
        }
       String ans = sb.substring(i);
       return ans.length() == 0 ? "0" : ans;
    }
    
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        removeKdigits(num, 0);
    }
}
