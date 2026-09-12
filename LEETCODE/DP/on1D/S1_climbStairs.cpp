#include<bits/stdc++.h>
using namespace std;
class Solution {

public:
    int stairs(int index, vector<int>& dp){
        if(index == 0 || index == 1){
            return 1;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        return dp[index] = stairs(index-1,dp) + stairs(index-2,dp);
    }

    int better(int n,vector<int>dp){
         for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
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
    int climbStairs(int n) {
        vector<int> dp(n+1, -1);
        dp[0] = 1, dp[1] = 1;

       
        return stairs(n,dp); 
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