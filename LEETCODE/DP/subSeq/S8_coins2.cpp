#include<bits/stdc++.h>
using namespace std;

int solve(int index, int k, vector<int> nums, vector<vector<int>>& dp){
    if(index == 0){
        if(k % nums[0] == 0){
            return 1;
        }else{
            return 0;
        }
    }
    if(dp[index][k] != -1){
        return dp[index][k];
    }
    int skip = 0 + solve(index - 1, k, nums,dp);
    int pick  = 0;

    if(nums[index] <= k){
        pick = solve(index-1, k-nums[index], nums, dp);
    }

    return dp[index][k] =  pick + skip;
}
int countwaysofcoins(int n, vector<int> nums, int k){
    vector<vector<int>> dp(n,vector<int>(k+1,-1));
    return solve(n-1,k,nums,dp);
}
int tabulation(int n, vector<int> nums, int k){
        vector<vector<int>> dp(n,vector<int>(k+1,false));
        // if(index == 0){
        //     if(k % nums[0] == 0){
        //         return 1;
        //     }else{
        //         return 0;
        //     }
        // }
        for(int i = 0; i <= k; i++){
            if(i % nums[0] == 0){
                dp[0][i] =  1;
            }
        }

        for(int index = 1; index < n; index++){
            for(int target = 1; target <= k; target++){
                int skip = 0 + dp[index - 1][target];
                int pick  = 0;
                if(nums[index] <= target){
                    pick = dp[index-1][target-nums[index]];
                }
                dp[index][target] = pick + skip;
            }
        } 
        return dp[n-1][k];
}

int space(int k, vector<int> nums){
    int  n = nums.size();

    vector<int> prev(k+1,0);
    for(int i = 0; i <= k; i++){
        if(i % nums[0] == 0){
            prev[i] =  1;
        }
    }
    for(int index = 1; index < n; index++){
        vector<int> temp(k+1,0);
            for(int target = 1; target <= k; target++){
                int skip = 0 + prev[target];
                int pick  = 0;
                if(nums[index] <= target){
                    pick = temp[target-nums[index]];
                }
                temp[target] = pick + skip;
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

    return 0;
}