package daily.strings;

public class L2213_longestsubarrayofOneRepeatChar {
    private int calculatelen(String s) {
        int maxlen = 1;
        int curr = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                curr = 1;
            }

            maxlen = Math.max(maxlen, curr);
        }

        return maxlen;
    }
    public int[] longestRepeating(String s, String q, int[] query) {    
        int n3 = query.length;

        char[] arr = s.toCharArray();
        char[] arr2 = q.toCharArray();
        int ans[] = new int[n3];
        
        for(int i = 0; i < n3; i++){

            arr[query[i]] = arr2[i];
           
            String newstring = new String(arr);
            int len =  calculatelen(newstring);
            ans[i] = len;  
        }
        return ans;
    }
    public static void main(String[] args) {

        // Optimal is segment trees 
        // brite force is quesy len is 10^ 5 and for each query we will check of O(n)
        // tc of brute is O(k * n)
    }
}
