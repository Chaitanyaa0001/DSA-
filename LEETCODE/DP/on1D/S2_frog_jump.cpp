#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    int solve(int n, vector<int> nums){
        if(n == 0){
            return 0;
        }

        int j1 = solve(n-1, nums) + abs(nums[n] - nums[n-1]);

        int j2 = INT_MAX;

        if(n > 1 ){
            j2 = solve(n-2, nums) + abs(nums[n] - nums[n-2]);
        }
        
        return min(j1,j2);
    }
    int frogJump(vector<int>& heights) {
        int n = heights.size();
        return solve(n-1,heights);
    }
};
// better 
class Solution {
public:
    int solve(int n, vector<int> nums, vector<int>& dp){
        if(n == 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int j1 = solve(n-1, nums,dp) + abs(nums[n] - nums[n-1]);

        int j2 = INT_MAX;

        if(n > 1 ){
            j2 = solve(n-2, nums,dp) + abs(nums[n] - nums[n-2]);
        }
        
        return dp[n] = min(j1,j2);
    }
    int frogJump(vector<int>& heights) {
        int n = heights.size();
        vector<int> dp(n+1,-1);
        return solve(n-1,heights, dp);
    }
};

// optimal 
class Solution {
public:
    int frogJump(vector<int>& heights) {
        int n = heights.size();
        vector<int> dp(n+1,-1);
        dp[0] = 0; dp[1] = abs(heights[0] - heights[1]);

        for(int i = 2; i < n; i++){
            int j1 = dp[i-1] + abs(heights[n] - heights[i-1]);
            int j2 = dp[i-2] + abs(heights[n] - heights[i-2]);
            dp[i] = min(j1,j2);
        }
        return dp[n-1];
    }
};
// space optimzation 
class Solution {
public:
    int frogJump(vector<int>& heights) {
        int n = heights.size();
        vector<int> dp(n+1,-1);
        int p2 = 0; int p1 = abs(heights[0] - heights[1]);
        int curr = 0;
        for(int i = 2; i < n; i++){
            int j1 = p1 + abs(heights[n] - heights[i-1]);
            int j2 = p2 + abs(heights[n] - heights[i-2]);
            curr = min(j1,j2);
            p2 = p1;
            p1 = curr;
        }
        return p1;
    }
};


// if there can be k jumps 

int main(){
    int n; 
    cin >> n;
    vector<int> v(n);
    for(auto i : v){
        cin >> i;
    }
    
    return 0;
}