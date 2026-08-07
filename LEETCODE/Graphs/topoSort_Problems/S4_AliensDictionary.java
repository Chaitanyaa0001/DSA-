package LEETCODE.Graphs.topoSort_Problems;

import java.util.*;

public class S4_AliensDictionary {

    public String findOrder(String[] w) {

        int n = w.length;

        HashSet<Character> set = new HashSet<>();
        for (String s : w) {
            for (char ch : s.toCharArray()) {
                set.add(ch);
            }
        }

        // Graph of 26 lowercase letters
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < n - 1; i++) {
            String s1 = w[i];
            String s2 = w[i + 1];

            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }

            // Invalid prefix case
            if (!found && s1.length() > s2.length()) {
                return "";
            }
        }

        int[] indegree = new int[26];

        for (int i = 0; i < 26; i++) {
            for (int nei : adj.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add only existing characters
        for (char ch : set) {
            if (indegree[ch - 'a'] == 0) {
                q.offer(ch - 'a');
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append((char) (curr + 'a'));

            for (int nei : adj.get(curr)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Cycle detected
        if (sb.length() != set.size()) {
            return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        
    }
}
