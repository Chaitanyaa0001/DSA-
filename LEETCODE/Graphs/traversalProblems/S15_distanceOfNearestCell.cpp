#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
    int m = mat.size();
    int n = mat[0].size();

    queue<pair<int,pair<int,int>>> q;
    // {row , col}

    vector<vector<int>> vis(m, vector<int>(n, 0));
    vector<vector<int>> ans(m, vector<int>(n, 0));

    for(int i = 0; i < m; i++){
        for(int j = 1; j < n; j++){
            if(mat[i][j] == 0){
                q.push({i,{j,0}});
                vis[i][j] = 1;
            }
        }
    }

    while (!q.empty()){
        int row = q.front().first;
        int col = q.front().second.first;
        int dis = q.front().second.second;
        ans[row][col] = dis;
        q.pop();
        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};
        for(int i = 0; i < 4; i++){

            int nr = row + dr[i];
            int nc = col + dc[i];

            if(0  <= nr && nr < m && 0 <= nc && nc < n && mat[nr][nc] == 1 && vis[nr][nc] == 0){
                q.push({nr,{nc,dis+1}});
                vis[nr][nc] = 1;
            }
        }
    }
    return ans;
    
}
int main(){

    return 0;
}