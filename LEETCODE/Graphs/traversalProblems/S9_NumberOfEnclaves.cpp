#include<bits/stdc++.h>
using namespace std;


// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
void bfs(vector<vector<int>>& grid, int row, int col, vector<vector<int>>& isSafe){
    queue<pair<int,int>> q;
    isSafe[row][col]  = true;
    q.push({row,col});
    
    int m = grid.size();
    int n = grid[0].size();
    while (!q.empty()){
        auto curr = q.front();
        q.pop();
        int r = curr.first;
        int c = curr.second;
        int dr[] ={-1,0,+1,0};
        int dc[] = {0,+1,0,-1};

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if( 0 <=  nr && nr < m && 0 <= nc && nc < n && !isSafe[nr][nc] && grid[nr][nc] == 1){
                q.push({nr,nc});
                isSafe[nr][nc] = true;
            }
        }
    }
}
int numEnclaves(vector<vector<int>>grid){
    int m = grid.size();
    int n = grid[0].size();
    vector<vector<int>> isSafe(m,vector<int>(n,0));

    for(int i = 0; i < n; i++){
        if(grid[0][i] == 1){
            bfs(grid,0,i,isSafe);
        }
        if( grid[m-1][i] == 1){
            bfs(grid,m-1,i,isSafe);
        }
    }
    for(int i = 1; i < m-1; i++){
        if(grid[i][0] == 1){
            bfs(grid,i,0,isSafe);
        }
        if(grid[i][n-1] == 1){
            bfs(grid,i,n-1,isSafe);
        }
    }
    int count = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1 && !isSafe[i][j]){
                count++;
            }
        }
    }
    return count;
}
int main(){

    return 0;
}