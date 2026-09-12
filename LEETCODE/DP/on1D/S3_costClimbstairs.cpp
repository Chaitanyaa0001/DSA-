#include<bits/stdc++.h>
using namespace std;

int solve(int i, vector<int> &h,vector<int>& dp){
    if(i == 0 || i == 1){
            return h[i]; 
    }
    if(dp[i] != -1){
        return dp[i];
    }
    int j1  = solve(i-1,h, dp) + h[i];
    int j2 = INT_MAX;
    if(i > 1){
        j2 = solve(i-2, h, dp) + h[i];
    }
    return  dp[i] = min(j1,j2);
}
int brute(int n, vector<int> cost){
    vector<int> dp(n,-1);
    return min(solve(n-1, cost, dp), solve(n-2, cost, dp));    

}

int better(int n , vector<int> cost) {
      int n = cost.size();
        vector<int> dp(n,-1);
        dp[0] = cost[0];
        dp[1] = cost[1];
        // return min(solve(n-1, cost, dp), solve(n-2, cost, dp));    
        for(int i = 2; i < n; i++){
            dp[i] =  min(dp[i-1], dp[i-2]) + cost[i];
        }
        return min(dp[n-1], dp[n-2]);
}

int optimal(int n, vector<int> cost){
       int prev2 = cost[0];
        int prev1 = cost[1];
        // return min(solve(n-1, cost, dp), solve(n-2, cost, dp));    
        for(int i = 2; i < n; i++){
             int curr =  cost[i]+  min(prev1,prev2);
             prev2 = prev1;
             prev1 = curr;
        }
        return min(prev1,prev2);
}

int main(){
    return 0;
}