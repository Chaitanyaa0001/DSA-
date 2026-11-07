#include<bits/stdc++.h>
using namespace std;



bool solve(int index, int target, vector<int> nums, int n, vector<vector<int>>& dp){
    if(target == 0){
        return true;
    }
    if(index < 0){
        return false;
    }
    if(dp[index][target] != -1){
        return dp[index][target];
    }
    bool skip = solve(index - 1, target, nums, n, dp);
    bool take = false;
    if(target >= nums[index]){
        take = solve(index - 1, target - nums[index], nums, n, dp);
    }
    dp[index][target] = (take || skip); // agar inme s ek bhi true hua toh true agar dono false to false 
}


bool subseqsumequaltoK(int k, vector<int> nums, int n){
    vector<vector<int>> dp(n,vector<int>(k+1,-1));
    return solve(n-1, k, nums, n,dp);
}


bool tabulation(vector<int> nums , int k, int n){
    vector<vector<int>> dp(n,vector<int>(k+1,-1));
    for(int i= 0; i < n; i++){
        dp[i][0] = true;
    }
    if(nums[0] <= k){
        dp[0][nums[0]] = true;
    }
    for(int index = 1; index < n; index++){
        for(int target = 1; target <= k; target++){
            bool skip = dp[index - 1][target];
            bool take = false;
            if(target >= nums[index]){
                take = dp[index - 1] [target - nums[index]];
            }
            dp[index][target] = take || skip;
        }
    }
    return dp[n-1][k];
}
bool spaceoptimization(vector<int>& nums, int k){
        int n  = nums.size();
        vector<int> prev(k+1,0);
        prev[0] = true;
        if(nums[0] <= k){
            prev[nums[0]] = true;
        }
        for(int index = 1; index < n; index++){
            vector<int> temp(k+1,-1);
            temp[0] = true;
            for(int target = 1; target <= k; target++){
                bool skip = prev[target];
                bool take = false;
                if(target >=  nums[index]){
                    take = prev[target - nums[index]];
                }
                temp[target] = take || skip;
            }
            prev = temp;
        }
        return prev[k];
    }
int main(){
    int n;
    cin >> n;
    int k;
    cin >> k;
    vector<int> nums(n);

    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    auto res = subseqsumequaltoK(k,nums,n);
    return 0;
}  