#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int solve(int r, int c1, int c2,vector<vector<vector<int>>>& dp, vector<vector<int>>& grid,int m, int n) {
        if(c1 < 0 || c2 < 0 || c1 >= n || c2 >= n) {
            return -1e8;
        }

        if(r == m - 1) {
            if(c1 == c2)return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }

        if(dp[r][c1][c2] != -1)return dp[r][c1][c2];
        int cherries = grid[r][c1];
        if(c1 != c2) cherries += grid[r][c2];
        int maxi = -1e8;
        for(int mv1 = -1; mv1 <= 1; mv1++) {
            for(int mv2 = -1; mv2 <= 1; mv2++) {
                maxi = max(maxi, solve(r + 1, c1 + mv1,c2 + mv2,dp, grid, m, n));
            }
        }
        return dp[r][c1][c2] = cherries + maxi;
    }
    int cherryPickup(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<vector<int>>> dp(rows,vector<vector<int>>(cols,vector<int>(cols, -1)));
        return solve(0, 0, cols - 1, dp, grid, rows, cols);
    }
};