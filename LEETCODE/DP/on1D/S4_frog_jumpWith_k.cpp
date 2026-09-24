#include<bits/stdc++.h>
using namespace std;

// Added '&' to h and dp to prevent massive memory copying

int solve(int n, int k, vector<int>& h, vector<int>& dp){
    if(n == 0){
        return 0;
    }
    if(dp[n] != -1){
        return dp[n];
    }
    // int j1 , j2, j3 at most k jumps;
    int minjumps = INT_MAX;
    for(int i = 1; i <= k; i++){
        if(n - i >= 0){
            int jumps = solve(n - i, k, h, dp) + abs(h[n] - h[n-i]);
            minjumps = min(jumps,minjumps);
        }
    }
    return dp[n] = minjumps;
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