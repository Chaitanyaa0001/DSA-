#include<bits/stdc++.h>
using namespace std;


int solve(int index, int target, vector<int>& nums, vector<vector<int>>& dp){
    if(index == 0){
        if(target == 0 && nums[0] == 0){
            return 2;
        }
        if(target == 0 || target == nums[0]){
            return 1;
        }
        return 0;
    }
    if(dp[index][target] != -1){
        return dp[index][target];
    }
    int skip = solve(index - 1, target, nums, dp);
    int pick = 0;
    if(target >= nums[index]){
        pick = solve(index - 1, target - nums[index], nums, dp);
    }
    return dp[index][target] = pick + skip;
}

int tabulation(vector<int>& nums, int k){
    int n = nums.size();
    vector<vector<int>> dp(n,vector<int>(k+1,-1));
    for(int i = 0; i < n; i++){
        dp[i][0] = 1;
    }
    if(nums[0] <= k){
        dp[0][nums[0]] = 1;
    }
    if(nums[0] == 0){
        dp[0][0] = 2;
    }

    for(int index = 1; index < n; index++){
        for(int target = 1; target <= k; target++){
            int skip = dp[index - 1][target];
            int pick = 0;
            if(target >= nums[index]){
                pick = dp[index - 1][target - nums[index]];
            }
            dp[index][target] = pick + skip;
        }
    }
    return dp[n-1][k];
}
int countsubsets(vector<int> nums, int k){
    int n = nums.size();
    vector<vector<int>> dp(n,vector<int>(k+1,-1));
    return solve(n-1, k, nums, dp);
}
int main(){
    int n;
    int k;
    cin >> n;
    cin >> k;

    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    return 0;
}