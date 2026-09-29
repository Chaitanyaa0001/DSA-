#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int solve(int row, int col, vector<vector<int>> grid, vector<vector<int>>& dp, int n){
        if(row == 0){
            return grid[row][col];
        }
        if(dp[row][col] != INT_MAX){
            return dp[row][col];
        }
        int up = INT_MAX;
        if(row > 0){
            up = grid[row][col] + solve(row - 1, col, grid, dp, n);
        }
        int leftup = INT_MAX;
        if(row > 0 && col > 0){
            leftup = grid[row][col] + solve(row-1, col - 1, grid, dp, n);
        }
        int rightup = INT_MAX;
        if(col+1 < n){
            rightup = grid[row][col] + solve(row - 1, col + 1, grid, dp, n);
        }

        return dp[row][col] =  min(up,min(leftup, rightup));
    }

    int minFallingPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> dp(n,vector<int>(n,INT_MAX));
        int mini = INT_MAX;
        for(int i = 0; i < n; i++){
            auto ans = solve(n-1, i, grid, dp, n);
            mini = min(mini, ans);
        }
        return mini;

    }

    int tabulation(vector<vector<int>> grid){
        int n = grid.size();
        vector<vector<int>> dp(n,vector<int>(n,0));

        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){

                int up = grid[i][j] + dp[i - 1][j];    

                int leftup = INT_MAX;
                if(j > 0){
                    leftup = grid[i][j] + dp[i-1][j-1];
                }
                int rightup = INT_MAX;
                if(j+1 < n){
                    rightup = grid[i][j] + dp[i - 1][j + 1];
                }
                dp[i][j] = min(up,min(leftup, rightup));
            }
        }
        int ans = INT_MAX;
        for(int i = 0; i < n; i++){
            ans = min(ans,dp[n-1][i]);
        }
        return ans;
    }
    int spaceOptimize(vector<vector<int>>& grid){
        int n = grid.size();
        vector<int> prev(n,0);
        for(int i = 0; i < n; i++){
            prev[i] = grid[0][i];
        }

        for(int i = 1; i < n; i++){
            vector<int> temp(n);
            for(int j = 0; j < n; j++){

                int up = grid[i][j] + prev[j];    
                int leftup = INT_MAX;
                if(j > 0){
                    leftup = grid[i][j] + prev[j-1];
                }
                int rightup = INT_MAX;
                if(j+1 < n){
                    rightup = grid[i][j] + prev[j + 1];
                }
                temp[j] = min(up,min(leftup, rightup));
            }
            prev = temp;
        }
        int ans = INT_MAX;
        for (int j = 0; j < n; j++) {
            ans = min(ans, prev[j]);
        }

        return ans;
    }

};