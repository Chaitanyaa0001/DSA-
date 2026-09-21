#include<bits/stdc++.h>
using namespace std;
// Hints
// Company
// Given an integer n, return all binary strings of length n that do not contain consecutive 1s. Return the result in lexicographically increasing order.
// A binary string is a string consisting only of characters '0' and '1'.
// Example 1
// Input: n = 3
// Output: ["000", "001", "010", "100", "101"]
// Explanation: All strings are of length 3 and do not contain consecutive 1s.
// Example 2
// Input: n = 2
// Output: ["00", "01", "10"]
// Constraints
// 1 <= n <= 20

class Solution {
public:
    vector<string> ans;
    void solve(int index, int n, string s, bool previousOne) {
        if (index == n) {
            ans.push_back(s);
            return;
        }
        // Always allowed to put 0
        solve(index + 1, n, s + "0", false);
        // Put 1 only when previous character wasn't 1
        if (!previousOne) {
            solve(index + 1, n, s + "1", true);
        }
    }
    
    vector<string> generateBinaryStrings(int n) {
        ans.clear();
        solve(0, n, "", false);
        return ans;
    }
};