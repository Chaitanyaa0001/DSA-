package daily.strings;

import java.util.HashSet;
import java.util.Stack;

public class L1081_SmallestSubSequenceOfDistinctChar {
  
    public String smallestSubsequence(String s) {
        int n = s.length();
        // we check mera same character dubara aya hai string mei to uska last index store krliya 
        int[] last = new int[26];
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            last[c - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                continue;
            }
            while(!stack.isEmpty()){
                char prev = stack.peek();
                if(prev > ch  && last[prev - 'a'] > i){
                    stack.pop();
                    set.remove(prev);
                }else{
                    break;
                }
            }
            stack.push(ch);
            set.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }


    public static void main(String[] args) {
        
    }
}
