#include<bits/stdc++.h>
using namespace std;


vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
    int m = image.size();
    int n = image[0].size();
    queue<pair<int,int>> q;
    int original = image[sr][sc];
    q.push({sr,sc});
    image[sr][sc] = color;
    if(original == color){
        return image;
    }
    
    while(!q.empty()){
        int row = q.front().first;
        int col = q.front().second;
        q.pop();
        int dr[] = {-1,0,+1,0};
        int dc[] = {0,+1,0,-1};
        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];
            if(0 <= nr && nr < m && 0 <= nc && nc < n && image[nr][nc] == original){
                q.push({nr,nc});
                image[nr][nc] = color;
            }
        }
    }
    return image;
}
