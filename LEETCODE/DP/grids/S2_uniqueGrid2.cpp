#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int solve(int row, int col, vector<vector<int>> grid, vector<vector<int>>& dp){
        if(grid[row][col] == 1){
            return 0;
        }
        if(row == 0 && col == 0){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int count = 0;
        if(col > 0){
            // left 
            count += solve(row, col - 1, grid, dp);
        } 
        if(row > 0){
            // up 
            count += solve(row - 1, col, grid, dp);
        }
        return dp[row][col] =  count;
    }
    int tabulation(vector<vector<int>> grid){
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m,vector<int>(n,0));
        if(grid[0][0] == 1){
            return 0;
        }
        dp[0][0] = 1;
       
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
               
                int left = 0;
                int up = 0;
                if(j > 0){
                    left = dp[i][j - 1];
                }
                if(i > 0){
                    up = dp[i - 1][j];
                } 
                dp[i][j] =  up + left;
            }
        }
        return dp[m-1][n-1];
    }
    int spaceOptimization(vector<vector<int>> grid){
        int m = grid.size();
        int n = grid[0].size();
        vector<int> prev(n,0);
        if(grid[0][0] == 1)
            return 0;
            
        prev[0] = 1;
        for(int i= 0; i < m; i++){
            vector<int> temp(n);
            for(int j = 0; j < n; j++){
                if( i == 0 && j == 0) continue;
                if(grid[i][j] == 1){
                    temp[j] = 0;
                    continue;
                } 
                int left = 0;
                int up = 0;
                if(j > 0){
                    left = temp[j - 1];
                }
                if(i > 0){
                    up = prev[j];
                } 
                temp[j] =  up + left;
            }
            prev = temp;
        }
        return  prev[0];
        // 0 0 0 0
        // 0 0 0 0
        // 0 0 0 0
        // 0 0 0 0
    }
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m,vector<int>(n,-1));
        return solve(m-1, n - 1, grid, dp);
    }
};