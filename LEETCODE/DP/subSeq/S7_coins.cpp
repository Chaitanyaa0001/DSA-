#include<bits/stdc++.h>
using namespace std;




int solve(int index, int target, vector<int> coins, vector<vector<int>>& dp){


    if(index == 0){
        if(target % coins[0] == 0){
            return target / coins[0];
        }else{
            return 1e9;
        }
    }

    if(dp[index][target] != -1){
        return dp[index][target];
    }
    int skip = 0 +  solve(index - 1, target, coins, dp);
    int pick = 1e9;

    if(coins[index] <= target){
        pick = 1 +  solve(index, target - coins[index], coins, dp);
    }

    return min(pick,skip);
}
int mincoinscount(vector<int> coint, int n, int target){
    vector<vector<int>> dp(n,vector<int>(target + 1, -1));
    return solve(n-1,target, coint, dp);
}

int tabulation(int target, vector<int> coins){
    int n = coins.size();
    vector<vector<int>> dp(n, vector<int>(target+1,1e9));

    for(int i = 1; i <= target; i++){
        if(i % coins[0] == 0){
            dp[0][i] = i / coins[0];
        }
    }

    for(int index = 1; index < n; index++){

        for(int k = 1; k <= target; k++){
            int skip = 0 +  dp[index - 1][k];
            int pick = 1e9;
            if(coins[index] <= k){
                pick = 1 +  dp[index][k - coins[index]];
            }
            dp[index][k] = min(skip,pick);
        }
    }
    return dp[n-1][target];
}
int main(){

    int n;
    cin >>n;

    vector<int> coins(n);
    for(int i = 0; i <n ; i++){
        cin >> coins[i];
    }
    return 0;
}