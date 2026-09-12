#include<bits/stdc++.h>
using namespace std;

// Added '&' to h and dp to prevent massive memory copying
int solve(int index, int k, vector<int>& h, vector<int>& dp){
    if(index == 0){
        return 0;
    }
    
    // 1. Check the memoization array first
    if(dp[index] != -1){
        return dp[index];
    }
    
    int minsteps = INT_MAX;
    
    for(int i = 1; i <= k; i++){
        if(index - i >= 0){
            int jump = solve(index - i, k, h, dp) + abs(h[index] - h[index - i]);
            minsteps = min(minsteps, jump);
        }
    }
    
    // 2. Save the result in the dp array before returning
    return dp[index] = minsteps;
}

int forKsteps(int n, int k, vector<int>& h){
    vector<int> dp(n, -1);
    // Start from the last index (n-1)
    return solve(n - 1, k, h, dp);
}

int main(){
    // Example usage
    vector<int> h = {10, 30, 40, 50, 20};
    int n = h.size();
    int k = 3;
    
    cout << forKsteps(n, k, h) << endl; 
    
    return 0;
}