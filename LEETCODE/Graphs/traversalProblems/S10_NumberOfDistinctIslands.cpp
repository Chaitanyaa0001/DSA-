#include<bits/stdc++.h>
using namespace std;
// You are given a 2D matrix grid of size N × M, where each cell contains either 0 or 1. Find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be same if and only if one island is equal to another (not rotated or reflected).
// Example 1:
// Input: grid = [[1, 1, 0, 0, 0], [1, 1, 0, 0, 0], [0, 0, 0, 1, 1],[0, 0, 0, 1, 1]]
// Output: 1
// Explanation:
// Same colored islands are equal. We have 2 equal islands, so we have only 1 distinct island.
// Example 2:
// Input: grid = [[1, 1, 0, 1, 1], [1, 0, 0, 0, 0], [0, 0, 0, 0, 1],[1, 1, 0, 1, 1]]
// Output: 3
// Explanation:
// Same colored islands are equal. We have 4 islands, but 2 of them are equal, So we have 3 distinct islands..

void bfs(vector<vector<int>>& grid, int row, int col, vector<vector<int>>& vis, set<vector<pair<int,int>>>& s){

    int m = grid.size();
    int n = grid[0].size();
    queue<pair<int,int>> q;
    q.push({row,col});
    vis[row][col] = true;
    int baser = row;
    int basec = col;
    vector<pair<int,int>>  shape;

    while (!q.empty()){
        auto curr = q.front();
        int r = curr.first;
        int c  = curr.second;
        q.pop();
        int a = r - baser;
        int b = c - basec;
        
        shape.push_back({a,b});

        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(0 <= nr && nr < m && 0<= nc && nc < n && grid[nr][nc] == 1 && !vis[nr][nc]){
                q.push({nr,nc});
                vis[nr][nc] = true;
            }
        }
    }

    sort(shape.begin(), shape.end());
    s.insert(shape);
}
int number_of_distinct_islands(vector<vector<int>> grid){

    int m = grid.size();
    int n  = grid[0].size();
    vector<vector<int>> vis(m,vector<int>(n,0));
    set<vector<pair<int,int>>> s;

    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1 && !vis[i][j]){
                bfs(grid,i,j,vis,s);
            }
        }
    }

    return s.size();
}
int main(){

    return 0;
}