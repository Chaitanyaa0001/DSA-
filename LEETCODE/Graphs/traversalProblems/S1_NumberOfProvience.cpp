#include <bits/stdc++.h>
using namespace std;

void dfs(int node, vector<vector<int>>& matrix, vector<int>& vis) {
    vis[node] = 1;
    for(int i = 0; i < matrix[node].size(); i++) {
        if(matrix[node][i] == 1 && vis[i] == 0) {
            dfs(i, matrix, vis);
        }
    }
}
int findCircleNum(vector<vector<int>>& isConnected) {
    int v = isConnected.size();
    vector<int> vis(v, 0);
    int count = 0;
    for(int i = 0; i < v; i++) {
        if(vis[i] == 0) {
            count++;
            dfs(i, isConnected, vis);
        }
    }

    return count;
}
int  main() {
    vector<vector<int>>isConnected = 
    {{1, 1, 0, 0, 0},
    {1, 1, 1, 0, 0},
    {0, 1, 1, 0, 0},
    {0, 0, 0, 1, 1},
    {0, 0, 0, 1, 1}};
    return 0;           
}

