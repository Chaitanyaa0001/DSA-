#include<bits/stdc++.h>
using namespace std;


int solve(int index, int w, vector<int>& wt, vector<int>& val, vector<vector<int>>& dp){
    

    if(index == 0){
        if(wt[0] <= w){
            return wt[0];
        }else{
            return 0;
        }
    }
    if(dp[index][w] != -1){
        return dp[index][w];
    }
    int skip =  solve(index - 1, w,  wt, val, dp);
    int pick = INT_MIN;
    if(wt[index] <= w){
        pick = solve(index  - 1, w - wt[index], wt , val, dp);
    }
    return dp[index][w] = max(pick,skip);
}
int knapsack(int w, int n, vector<int> wt, vector<int> val){
    int n = wt.size();
    vector<vector<int>> dp(n,vector<int>(n,-1));
    return solve(n-1, w, wt, val, dp);    
}

int tabulation(int w, vector<int> wt, vector<int> val){
    int n = wt.size();    
    vector<vector<int>> dp(n,vector<int>(w+1, -1));\

    for(int i = wt[0]; i < n; i++){
        dp[0][i] = wt[0];
    }

}
int main(){    
    int n;
    int w;
    cin >> n >> w;
    vector<int> val(n);
    vector<int> wt(n);
    for(int i =0; i < n; i++){
        cin >>val[i];
    }
    for(int i = 0; i < n; i++){
        cin >> wt[i];
    }
    return 0;
}