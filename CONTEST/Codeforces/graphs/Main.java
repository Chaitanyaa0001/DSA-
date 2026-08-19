import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            
            Set<Character> set = new HashSet<>();
            
            
            for (int i = 0; i < n; i++) {
                String word = sc.next();
                char ch = word.charAt(0);  // 'a', 'b', 'c' (already lowercase)
                set.add(ch);
            }
        
            // Step 3: Abbreviations 
            String[] abbreviations = new String[m];
            for (int i = 0; i < m; i++) {
                abbreviations[i] = sc.next();  // "AG", "BG", etc. (uppercase)
            }
            
            // Step 4: Track created abbreviations
            boolean[] isCheck = new boolean[m];
            boolean changed = true;
            
            // Step 5: Main loop
            while (changed) {
                changed = false;
                
                for (int i = 0; i < m; i++) {
                    if (isCheck[i]) continue;
                    

                    String abbr = abbreviations[i].toLowerCase();  // "AG" → "ag"
                    boolean canCreate = true;
                    
                    // Step 6: Har character check karo (sab lowercase)
                    for (int j = 0; j < abbr.length(); j++) {
                        char ch = abbr.charAt(j);  // 'a', 'g'
                        if (!set.contains(ch)) {
                            canCreate = false;
                            break;
                        }
                    }
                    
                    // Step 7: Agar ban sakta hai toh create karo
                    if (canCreate) {
                        isCheck[i] = true;
                        changed = true;
                        
                        // Step 8: Abbreviation ka first letter add karo (lowercase)
                        char firstChar = abbr.charAt(0);  // 'a'
                        set.add(firstChar);
                    }
                }
            }
            
            // Step 9: Check if all created
            boolean allCreated = true;
            for (boolean b : isCheck) {
                if (!b) {
                    allCreated = false;
                    break;
                }
            }
            
            System.out.println(allCreated ? "YES" : "NO");
        }
        sc.close();
    }
}