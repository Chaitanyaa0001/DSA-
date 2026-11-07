#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int solve(int row,int col, vector<vector<int>> grid, vector<vector<int>>& dp, int n){
        if(row == n-1){
            return grid[row][col];
        }
        if(dp[row][col] != INT_MAX){
            return dp[row][col];
        }

        int left =  grid[row][col] +  solve(row + 1, col, grid, dp, n);
        int right = grid[row][col] + solve(row + 1, col + 1, grid, dp, n);
        return dp[row][col] =  min(left,right);
    }
    int minimumTotal(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<int>> dp(n,vector<int>(n,INT_MAX));
        return solve(0,0,grid, dp, n);
    }

    int tabulation(vector<vector<int>> grid){

        int n = grid.size();
        vector<vector<int>> dp(n,vector<int>(n,INT_MAX));
        dp[0][0] = grid[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                int left = INT_MAX;
                if(i > 0){
                    left =  grid[i][j] + dp[i - 1][j];
                }
                int right = INT_MAX;
                if(j > 0){
                    right = grid[i][j] + dp[i - 1][j - 1];

                }
                dp[i][j] = min(left , right);
            }
        }
        return dp[n-1][n-1];
    }

    int space(vector<vector<int>> grid){
        int n = grid.size();
        vector<int> prev(n,0); 

        for(int i = 0; i < n; i++){
            vector<int> temp(n);
            for(int j = 0; j <= i; j++){
                if( i == 0 && j == 0) {
                    prev[0] = grid[i][j];
                    continue;
                }
                int left = INT_MAX;
                if( j < i){
                    left =  grid[i][j] + prev[j];
                }
                int right = INT_MAX;
                if(j > 0){
                    right = grid[i][j] + prev[j - 1];
                }
                temp[j] = min(left,right);
            }
            prev = temp;
        }
        return *min_element(prev.begin(), prev.end());
    }
};