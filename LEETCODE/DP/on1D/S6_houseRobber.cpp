#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    int solve(int n,vector<int>& nums, vector<int>& dp){

        if( n == 0 ){
            return nums[0];
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int pick = nums[n] + solve(n -2, nums,dp);
        int notpick =  solve(n-1,nums,dp);
        return dp[n] = max(pick,notpick);
    }
    int tabulation(vector<int>& nums){
        int n  = nums.size();
        vector<int> dp(n,-1);
        dp[0] = nums[0];

        for(int i = 1; i < n; i++){
            int take = nums[i];
            if( i > 1){
                take += dp[i-2];
            }
            int nontake = 0 + dp[i-1];
            dp[i] = max(take,nontake);
        }
        return dp[n-1];
    }
    int space(vector<int>& nums){
        int n = nums.size();
        int p1 = nums[0];
        int p2 = 0;


        int curr = 0;
        for(int i= 2; i < n; i++){
              int take = nums[i];
            if( i > 1){
                take += p2;
            }
            int nontake = 0 + p1;
            curr = max(take,nontake);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
    int nonAdjacent(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n,-1);
        return solve(n-1, nums,dp);
    }
};

int main(){
    int n;
    cin >> n;
    vector<int> nums(n);

    for(int i  = 0; i < n; i++){
        cin >> nums[i];
    }
    vector<int> dp(n+1,-1);
   
}