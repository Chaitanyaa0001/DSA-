#include<bits/stdc++.h>;
using namespace std;
class DisjointSet{ 
public : 
    vector<int> size;
    vector<int> parent;
    DisjointSet(int n){
        size.resize(n);
        parent.resize(n);
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    int findparent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findparent(parent[node]);
    }
    void unionsize(int u, int v){
        int uu = findparent(u);
        int uv = findparent(v);
        if(uu == uv) return ;

        if(size[uu] < size[uv]){
            parent[uu] = uv;
            size[uv] += size[uu];
        }else{
            parent[uv] = uu;
            size[uu] += size[uv];
        }
    }
};
class Solution {
public:
    int largestIsland(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<pair<int,int>> zeroPos;

        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};
        int nodes = n * n;
        DisjointSet ds(nodes);
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){

                int currentnode = (row * n) + col;

                if(grid[row][col] == 0){
                    zeroPos.push_back({row,col});
                }else{
                    for(int i =0; i < 4; i++){
                        int nr =  row + dr[i];
                        int nc = col + dc[i];
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1){

                            int adjNode = (nr  * n) + nc;
                            if(ds.findparent(currentnode) != ds.findparent(adjNode)){
                                ds.unionsize(currentnode, adjNode);
                            }
                        }
                    }
                }
            }
        }

        if(zeroPos.empty()){
            return n * n;
        }

        int maxIsland = 0;
        for(int i = 0; i < zeroPos.size(); i++){
            unordered_set<int> toCheck;
            int row = zeroPos[i].first;
            int col = zeroPos[i].second;


                for(int j = 0 ; j < 4 ; j++){
                    int nr = row + dr[j];
                    int nc = col + dc[j];

                    if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                        if(grid[nr][nc] == 1){
                            int adjNode = (nr  * n ) + nc;
                            int ult = ds.findparent(adjNode);
                            toCheck.insert(ult);
                            
                        }
                    }
                }
            int currISize = 1;
            if(!toCheck.empty()){
                for(auto it : toCheck){
                    currISize += ds.size[it];
                }
            }
            maxIsland = max(maxIsland, currISize);
        }
        return maxIsland;
    }
};