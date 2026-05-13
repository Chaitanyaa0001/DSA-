package LEETCODE.SlidingWindow;

import java.util.HashMap;

public class S6_LongestSunStringwithDistinctKCharacters {
    private static int bruteforce(String s, int k){
        int n = s.length();
        // aaabbccd 
        int maxlen = 0;
        
        for(int i = 0; i < n; i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0) + 1);
                if(map.size() > k){
                    break;
                }
                maxlen = Math.max(j - i + 1, maxlen);
            }
        }
        return maxlen;
    }

    private static int optimal(String s, int k){
        int maxlen = 0; 
        int len = 0; 
        int r = 0; int l = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) + 1);

            if(map.size() > k){
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if(map.size() <= k){
                maxlen = Math.max(maxlen, r - l  + 1);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        String s = " aaabbccd";
        bruteforce(s, 3);
        optimal(s, 0);


    }
}
