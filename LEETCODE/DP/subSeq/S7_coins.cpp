#include <bits/stdc++.h>
using namespace std;


// ============================================================
// 1. MEMOIZATION
// ============================================================

int solve(int index, int target, vector<int>& coins,
          vector<vector<int>>& dp) {

    // Base case: only coin[0] is available
    if(index == 0) {
        if(target % coins[0] == 0) {
            return target / coins[0];
        }

        return 1e9;
    }

    if(dp[index][target] != -1) {
        return dp[index][target];
    }

    // Don't take current coin
    int skip = solve(index - 1, target, coins, dp);

    // Take current coin
    int pick = 1e9;

    if(coins[index] <= target) {
        pick = 1 + solve(index, target - coins[index], coins, dp);
    }

    return dp[index][target] = min(pick, skip);
}


int minCoinsMemoization(vector<int>& coins, int target) {

    int n = coins.size();

    vector<vector<int>> dp(
        n,
        vector<int>(target + 1, -1)
    );

    int ans = solve(n - 1, target, coins, dp);

    return ans;
}


// ============================================================
// 2. TABULATION
// ============================================================

int tabulation(int target, vector<int>& coins) {

    int n = coins.size();

    vector<vector<int>> dp(
        n,
        vector<int>(target + 1, 1e9)
    );

    // Base case
    // Only coins[0] is available
    for(int i = 0; i <= target; i++) {

        if(i % coins[0] == 0) {
            dp[0][i] = i / coins[0];
        }
    }


    for(int index = 1; index < n; index++) {

        for(int k = 0; k <= target; k++) {

            // Don't take current coin
            int skip = dp[index - 1][k];

            // Take current coin
            int pick = 1e9;

            if(coins[index] <= k) {
                pick = 1 + dp[index][k - coins[index]];
            }

            dp[index][k] = min(skip, pick);
        }
    }

    return dp[n - 1][target];
}


// ============================================================
// 3. SPACE OPTIMIZATION
// ============================================================

int space(int target, vector<int>& coins) {

    int n = coins.size();

    vector<int> prev(target + 1, 1e9);


    // Base case
    // Only coins[0]
    for(int i = 0; i <= target; i++) {

        if(i % coins[0] == 0) {
            prev[i] = i / coins[0];
        }
    }


    for(int index = 1; index < n; index++) {

        vector<int> temp(target + 1, 1e9);

        for(int k = 0; k <= target; k++) {

            // Don't take current coin
            int skip = prev[k];

            // Take current coin
            int pick = 1e9;

            if(coins[index] <= k) {
                pick = 1 + temp[k - coins[index]];
            }

            temp[k] = min(skip, pick);
        }

        prev = temp;
    }

    return prev[target];
}


// ============================================================
// MAIN
// ============================================================

int main() {

    int n;
    cin >> n;

    vector<int> coins(n);

    for(int i = 0; i < n; i++) {
        cin >> coins[i];
    }

    int target;
    cin >> target;


    // -------------------------------
    // Memoization
    // -------------------------------

    int ans1 = minCoinsMemoization(coins, target);


    // -------------------------------
    // Tabulation
    // -------------------------------

    int ans2 = tabulation(target, coins);


    // -------------------------------
    // Space Optimized
    // -------------------------------

    int ans3 = space(target, coins);


    // -------------------------------
    // Print answers
    // -------------------------------

    if(ans1 >= 1e9) {
        cout << "No solution\n";
    }
    else {
        cout << "Memoization: " << ans1 << endl;
        cout << "Tabulation: " << ans2 << endl;
        cout << "Space Optimized: " << ans3 << endl;
    }


    return 0;
}