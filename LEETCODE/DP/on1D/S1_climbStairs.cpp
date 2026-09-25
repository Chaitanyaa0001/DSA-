#include<bits/stdc++.h>
using namespace std;
class Solution {

public:
  
    int solve(int n, vector<int>& dp){
        if(n == 0 || n  == 1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
       return dp[n] = solve(n-1,dp) + solve(n-2,dp);
    }
    int climbStairs(int n) {
        vector<int> dp(n+1,-1);

        return solve(n,dp);
    }    
// ------------------------------------------------------------------------------------------

    int better(int n){
        vector<int> dp(n+1,-1);
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
// ----------------------------------------------------
    int optimal(int n){
        int p1 = 1, p2 = 1;
        int curr = 0;
        for(int i = 2; i <= n; i++){
            curr = p1 + p2;
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
};