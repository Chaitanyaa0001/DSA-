
#include <bits/stdc++.h>
using namespace std;

string printsubseq(string s1, string s2) {
    int n = s1.size(), m = s2.size();

    // Step 1: Create the DP table
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

    // Step 2: Fill the DP table
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = max(dp[i - 1][j],
                               dp[i][j - 1]);
            }
        }
    }

    // Step 3: Backtrack to construct the LCS
    string ans = "";
    int i = n, j = m;
    while (i > 0 && j > 0) {
        if (s1[i - 1] == s2[j - 1]) {
            ans += s1[i - 1];
            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        } else {
            j--;
        }
    }
    reverse(ans.begin(), ans.end());
    return ans;
}

int main() {
    string s1, s2;
    cin >> s1 >> s2;

    string ans = printsubseq(s1, s2);

    cout << ans << '\n';
    cout << "Length: " << ans.size() << '\n';

    return 0;
}
