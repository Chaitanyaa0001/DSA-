#include<bits/stdc++.h>
using namespace std;


int solve(int index, int n, vector<int> nums, vector<vector<int>>& dp){

    if(index == 0){
       return  (n * nums[0]);
        
    }
    if(dp[index][n] != -1){
        return dp[index][n];
    }
    int skip = 0 + solve(index - 1, n, nums, dp);
    int pick = INT_MIN;
    int rodlen = index +1;
    if(rodlen <= n){
        pick = nums[index] + solve(index,n-rodlen, nums,dp);
    }

    return dp[index][n] = max(pick,skip);
}

int tabulation(vector<int> nums){
    int n = nums.size();
        vector<vector<int>> dp(n,vector<int>(n+1,0));

        for(int i = 0; i <= n; i++){
            dp[0][i] = i * nums[0];
        }
        for(int index = 1; index < n; index++){
            for(int j = 0; j <= n; j++){
                int skip = 0 + dp[index - 1][j];
                int pick = INT_MIN;
                int rodlen = index +1;
                if(rodlen <= j){
                    pick = nums[index] + dp[index][j-rodlen];
                }
                dp[index][j] = max(pick,skip);
            }
        }
        return dp[n-1][n];
}
int space(vector<int> nums){
    int n = nums.size();
        vector<int> prev(n+1,0);

        for(int i = 0; i <= n; i++){
            prev[i] = i * nums[0];
        }
        for(int index = 1; index < n; index++){
            vector<int> temp(n+1,0);
            for(int j = 0; j <= n; j++){
                int skip = 0 + prev[j];
                int pick = INT_MIN;
                int rodlen = index +1;
                if(rodlen <= j){
                    pick = nums[index] + temp[j-rodlen];
                }
                temp[j] = max(pick,skip);
            }
        }
        return prev[n-1];
}
int cutRod(vector<int> &nums) {
    int n = nums.size();
    vector<vector<int>> dp(n,vector<int>(n+1,-1));
    return solve(n-1, n, nums, dp);
}
int main(){
    int n;
    cin >> n;
    int k;
    cin >> k;
    vector<int> nums(n);
    for(int i =0; i < n; i++){
        cin >> nums[i];
    }



    return 0;
}