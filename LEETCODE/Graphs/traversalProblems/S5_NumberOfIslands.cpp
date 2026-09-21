#include<bits/stdc++.h>
using namespace std;



void bfs(int row,int col, vector<vector<char>>& grid, vector<vector<int>>& vis, int m, int n){
    queue<pair<int,int>> q;
    q.push({row,col});
    int dr[] = {-1,0,+1,0};
    int dc[] = {0,+1,0,-1}; 
    vis[row][col] = 1;
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(0 <= nr && nr < m && 0 <= nc && nc < n && grid[nr][nc] == '1' && vis[nr][nc] == 0){
                q.push({nr,nc});
                vis[nr][nc] = 1;
            }
        }
    }
}
int numIslands(vector<vector<char>>& grid) {
    int m = grid.size();
    int n = grid[0].size();
    vector<vector<int>> vis(m,vector<int>(n,0));
    int count = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(vis[i][j] == 0 && grid[i][j] == '1'){
                count++;
                bfs(i,j,grid, vis , m, n);
            }
        }
    }
    return count;
}

int main(){
    int n;
    cin >>n;
    return 0;
}