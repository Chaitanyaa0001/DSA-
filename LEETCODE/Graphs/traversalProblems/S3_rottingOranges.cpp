#include<bits/stdc++.h>
using namespace std;


 int orangesRotting(vector<vector<int>>& grid) {

    int m = grid.size();
    int n = grid[0].size();
    queue<pair<int,pair<int,int>>> q;
    int count_fresh = 0;
    vector<vector<int>> vis(m,vector<int>(n,0));

    // row col and time 
    for(int i = 0; i < m; i++){
        for(int j  = 0; j < n; j++){
            if(grid[i][j] == 2){
                q.push({i,{j,0}});
                vis[i][j] = 1;
            }else if( grid[i][j] == 1){
                count_fresh++;
            }
        }
    }
    int time = 0;
    int rottenFresh  = 0;
    while (!q.empty()){
        // {r,{c,t}}
        int r = q.front().first; 
        int c = q.front().second.first;
        int t = q.front().second.second;
        q.pop();

        time = max(time,t);
        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};

        for(int i = 0; i < 4; i++){

            int nr = r + dr[i];
            int nc = c + dc[i];

            if(0 <= nr && nr < m && 0 <= nc && nc < n  && grid[nr][nc] == 1 && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.push({nr,{nc,t + 1}});
                    rottenFresh++;
            }
        }
    }
    if(count_fresh != rottenFresh){
        return -1;
    }

    return time;
    
}
int main(){
    int n;
    cin >> n;

    return 0;
}