
#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
// memoization 
    int solve(int row, int col, int m, int n, vector<vector<int>>& dp){
        if(row == m && col == n){
            return 1;
        }
        if(row < m && col < n && dp[row][col] != -1){
            return dp[row][col];
        }
        // down
        int count = 0; 
        if(row < m){
            count += solve(row + 1, col, m, n, dp);
        }
        // right
        if(col < n){
            count += solve(row, col + 1, m, n, dp);
        }
        return dp[row][col] = count;
    }
    int tabulation(int m, int n){
        vector<vector<int>> dp(n,vector<int>(m));
        dp[n-1][m-1] = 0;

        for(int i = n - 1; i >= 0; i--){
            for(int j = m-1 ; j >= 0; j--){
                if(i == n-1 && j == m-1) continue;

                int down = 0, right = 0;
                if(i < n-1){
                    down = dp[i+1][j];
                }
                if(j < m-1){
                    right = dp[i][j+1];
                }
                dp[i][j] = right + down;
            }
        }
        return dp[0][0];
    }
    int spaceoptimization(int n, int m){

        vector<int> prev(m,0);

        for(int i = n-1; i >= 0; i--){
            vector<int> temp(m, 0);
            for(int j = m-1; j >= 0; j--){
                if(i == n-1 && j == m-1){
                    temp[j] = 1;
                    continue;
                }
            
                int down = 0;
                int right = 0;
            
                if(i < n-1){
                    down = prev[j];
                }
                if(j < m-1){
                    right = temp[j+1];
                }
                temp[j] = down + right;
            }
            prev = temp;
        }
        return prev[0];
    }

    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m,vector<int>(n,-1));

        return solve(0,0,m-1,n-1, dp);
    }
};