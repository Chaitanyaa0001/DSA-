package CONTEST.Codeforces.maths;

import java.io.*;
import java.util.*;

// A. The Best Card
// time limit per test2 seconds
// memory limit per test512 megabytes
// In a card game, there are n
//  cards with values 2,3,4,…,n+1
// .

// To determine which of two cards with values x
//  and y
//  wins, apply the following rules:

// if one of the numbers x
//  and y
//  is divisible by the other, the card with the smaller value wins;
// otherwise, the card with the larger value wins.
// For example, between cards 2
//  and 6
// , card 2
//  wins because 6
//  is divisible by 2
// . Between cards 4
//  and 6
// , card 6
//  wins because neither of these numbers is divisible by the other.

// Determine whether there exists a card that wins against every other card.

// Input
// The first line contains an integer t
//  (1≤t≤104
// ) — the number of test cases.

// The only line of each test case contains an integer n
//  (2≤n≤2⋅105
// ) — the number of cards in the game.

// Additional constraints on the input:

// the sum of n
//  over all test cases does not exceed 3⋅106
// .
// Output
// For each test case, print YES if there is a card that wins against all other cards, and NO otherwise.

// Each letter may be printed in either case. For example, YES, yes, and yEs are all recognized as a positive answer.

// Example
// InputCopy
// 5
// 2
// 3
// 4
// 5
// 8
// OutputCopy
// YES
// NO
// YES
// NO
// NO
// Note
// In the first test case, the available cards have values 2
//  and 3
// . Card 3
//  wins against card 2
// .

// In the second test case, the available cards have values 2
// , 3
// , and 4
// . Card 2
//  wins against card 4
// , card 3
//  wins against card 2
// , and card 4
//  wins against card 3
// , so there is no suitable card.



public class Main {
    static final int MAX = 200001;
    static boolean[] prime = new boolean[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(prime[n + 1] ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }
}