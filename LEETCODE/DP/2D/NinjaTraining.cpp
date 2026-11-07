#include<bits/stdc++.h>
using namespace std;

// A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.
// Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.
// Example 1:
// Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
// Output: 210
// Explanation:
// Day 1: fighting practice = 70
// Day 2: stealth training = 50
// Day 3: fighting practice = 90
// Total = 70 + 50 + 90 = 210
// This gives the optimal points.


class Solution {
  public:
//   memoization  
    int solve(int day, int last,vector<vector<int>> grid, vector<vector<int>>& dp){
        if(day == 0){
            int maxi = INT_MIN;
            for(int i = 0; i < 3; i++){
                if(last != i){
                    maxi = max(maxi,grid[day][i]);
                }
            }
            return maxi;
        }

        if(dp[day][last] != -1){
            return dp[day][last];
        }
        int maxi = 0;
        for(int i = 0; i < 3; i++){
            if(last != i){
                int point = grid[day][i] + solve(day - 1, i, grid, dp);
                maxi = max(point, maxi);
            }
        }
        return dp[day][last] =  maxi;
    
    }

    // tabulation 


    int tabulation(vector<vector<int>> grid, int n){
        vector<vector<int>> dp(n,vector<int>(4,-1));
        dp[0][0] = max(grid[0][1],grid[0][2]); dp[0][1] = max(grid[0][0],grid[0][2]); dp[0][2] = max(grid[0][0],grid[0][1]);
        dp[0][3] = max(grid[0][0],max(grid[0][1],grid[0][2]));

        for(int day = 1; day < n ; day++){
            for(int last = 0; last < 4; last++){

                for(int i  = 0; i < 3; i++){
                    int point = grid[day][i] + dp[day-1][i];
                   dp[day][last] = max(point, dp[day][last]);
                }
              
            }
        }
        return dp[n-1][3];
    }
    // -------------------------------------------

    int spaceoptimization(vector<vector<int>> grid){

            vector<int> prev(4,0);
            int n  = grid.size();

            prev[0] = max(grid[0][1],grid[0][2]); 
            prev[1] = max(grid[0][0],grid[0][2]);
            prev[2] = max(grid[0][0],grid[0][1]);
            prev[3] = max(grid[0][0],max(grid[0][1],grid[0][2]));

            for(int day = 1; day < n; day++){
                vector<int> temp(4,0);

                for(int last = 0; last < 4; last++){

                    for(int task = 0; task < 3; task++){
                        if(last != task){

                            int point = grid[day][task] + prev[task];
                            temp[last] = max(temp[last],point); 
                        }
                    }
                }
                prev = temp;
            }

            return prev[3];
    }
    int maximumPoints(vector<vector<int>>& grid) {
    // code here
    // so my ninja is going for training program for n days
    // he can do these activity - run, fight, learn 
    // each activity has some point on each dat as geek wants to omprocve all skills and he cant do same activity on 2 consiu=ctuive dats 
    // so he can do same activity on 2 days 
        int n = grid.size();
        vector<vector<int>> dp(n,vector<int>(4,-1));

        return solve(n-1,3,grid,dp);
    }
};

int main(){
    int n;
    cin >> n;
    vector<vector<int>> nums(n,vector<int>(3));

    for(int i =0; i < n; i++){
        for(int j = 0; j < 3; j++){
            
            cin >> nums[i][j];
        }
    }
    return 0;
}