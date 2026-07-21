package daily.strings;

import java.util.ArrayList;
import java.util.List;

public class L3199_MaximizeActiveSessionInString {
    
    public static  int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();
        int activeCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                activeCount++;
            }
        }
        // tootal nikal liya 

        // Store length of every block of 0's
        // zero store 
        List<Integer> inactiveBlocks = new ArrayList<>();

        int i = 0;

        while (i < n) {

            if (s.charAt(i) == '0') {

                int start = i;

                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                // length  krva li store 
                inactiveBlocks.add(i - start);

            } else {
                i++;
            }
        }

    //    max nikalo ab 
        int maxPairSum = 0;
        for (int j = 1; j < inactiveBlocks.size(); j++) {
            maxPairSum = Math.max(maxPairSum,inactiveBlocks.get(j) + inactiveBlocks.get(j - 1));
        }

        return activeCount + maxPairSum;
    }

    public static void main(String[] args) {
        maxActiveSectionsAfterTrade(null);
        
        
    }
}
