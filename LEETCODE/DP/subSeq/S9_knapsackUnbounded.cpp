#include<bits/stdc++.h>
using namespace std;



class Solution {
  public:
  int solve(int index, int cap, vector<int> val, vector<int> wt,vector<vector<int>> dp){
      
      if(index == 0){
        return (cap / wt[0]) * val[0]; 
      }
      if(dp[index][cap] != -1){
          return dp[index][cap];
      }
      int skip = 0 + solve(index - 1, cap, val, wt, dp);
      int pick = 0;
      if(wt[index] <= cap){
          pick = val[index] + solve(index, cap - wt[index], val, wt, dp);
      }
      return dp[index][cap] = max(pick, skip);
  }
    int knapSack(vector<int>& val, vector<int>& wt, int cap) {
   
        int n = val.size();
        vector<vector<int>> dp(n, vector<int>(cap+1,false));
        for(int i = 0; i <= cap; i++){
            dp[0][i] = (i / wt[0]) * val[0]; 
        }
        
        for(int index = 1; index < n; index++){
            for(int target = 0; target <= cap; target++){
                int skip = 0 + dp[index - 1][target];
                int pick = 0;
                if(wt[index] <= target){
                    pick = val[index] + dp[index][target - wt[index]];
                }
                dp[index][target] = max(pick, skip);
            }
        }
        return dp[n-1][cap];
    }
};