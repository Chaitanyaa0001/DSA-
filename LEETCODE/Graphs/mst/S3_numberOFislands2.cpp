// Problem Statement
// You are given an empty m x n grid where all cells are initially water (0).
// You are given a list positions, where positions[i] = [row, col] means that the cell at (row, col) is changed from water to land (1).
// After each operation, return the number of islands in the grid.
// An island is a group of horizontally or vertically connected land cells.
// You can assume that every position in positions is initially water.
// Example
// Input:  m = 3  n = 3
// positions = [[0,0], [0,1], [1,2], [2,1]]
// Initially:
// 0 0 0
// 0 0 0
// 0 0 0
// After [0,0]:
// 1 0 0
// 0 0 0
// 0 0 0
// Islands = 1
// After [0,1]:
// 1 1 0
// 0 0 0
// 0 0 0
// Islands = 1
// (0,0) and (0,1) are connected.
// After [1,2]:
// 1 1 0
// 0 0 1
// 0 0 0
// Islands = 2
// After [2,1]:
// 1 1 0
// 0 0 1
// 0 1 0
// Islands = 3
// So the output is:
// [1, 1, 2, 3]
// Constraints
// 1 <= m, n <= 10^4
// 1 <= m * n <= 10^4
// 1 <= positions.length <= 10^4
// 0 <= row < m
// 0 <= col < n
#include<bits/stdc++.h>
using namespace std;

class DisjointSet{
    public :
    vector<int> size;
    vector<int> parent;
    DisjointSet(int n){
        size.resize(n);
        parent.resize(n);

        for(int i = 0; i < n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    int findparent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findparent(parent[node]);
    }
    void unionsize(int u, int v){
        int ulu = findparent(u);
        int ulv = findparent(v);

        if(ulu == ulv) return ;

        if(size[ulu] < size[ulv]){
            parent[ulu] = ulv;
            size[ulv] += size[ulu];
        }else{
            parent[ulv] = ulu;
            size[ulu] += size[ulv];
        }
    }
};


vector<int>  number_of_islands(int n, int m , vector<vector<int>> queries){

    vector<vector<int>> vis(n, vector<int>(m,0));

    int count = 0;
    int nodes = n  * m;

    DisjointSet ds(nodes);
    vector<int> ans ;

    for(int i = 0; i < queries.size(); i++){
        int row = queries[i][0];
        int col = queries[i][1];
        if(vis[row][col]){
            ans.push_back(count);
            continue;
        }

        vis[row][col] = 1;
        count++;

        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};

        
        int currentNode = (row * m) + col;
        for(int i = 0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if( nr >= 0 && nr < n &&  nc >= 0 && nc < m){ // valid condition

                if(vis[nr][nc] == 1){ // ager mera land hai toh hi check kro ! 
                    int adjNode = (nr * m + nc);

                    if(ds.findparent(currentNode) != ds.findparent(adjNode)){
                        count--;
                        ds.unionsize(currentNode,adjNode);
                    }
                }
            }
        }
        ans.push_back(count);
    }
    return ans;
}
int main(){

    return 0;
}