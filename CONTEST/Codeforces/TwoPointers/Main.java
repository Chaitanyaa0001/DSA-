package CONTEST.Codeforces.TwoPointers;

import java.util.*;

public class Main {

    static int solve(String u, int x, int s, int k) {
        int empty = x;
        int ans = 0;

        int[] rem = new int[x];
        int open = 0;

        int usedA = 0;

        for (char ch : u.toCharArray()) {

            // First k ambiverts behave like Introverts
            if (ch == 'A') {
                if (usedA < k) {
                    ch = 'I';
                } else {
                    ch = 'E';
                }
                usedA++;
            }

            if (ch == 'I') {
                if (empty > 0) {
                    empty--;
                    ans++;
                    if (s > 1) {
                        rem[open++] = s - 1;
                    }
                }
            } else { // E
                if (open > 0) {
                    ans++;
                    rem[0]--;

                    if (rem[0] == 0) {
                        for (int i = 1; i < open; i++) {
                            rem[i - 1] = rem[i];
                        }
                        open--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int x = sc.nextInt();
            int s = sc.nextInt();

            String u = sc.next();

            int amb = 0;
            for (char c : u.toCharArray()) {
                if (c == 'A') amb++;
            }

            int ans = 0;

            for (int k = 0; k <= amb; k++) {
                ans = Math.max(ans, solve(u, x, s, k));
            }

            System.out.println(ans);
        }
    }
}