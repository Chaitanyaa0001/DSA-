#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<vector<int>> edges = {{0, 1,4},{0, 2,3},{1, 2, 5},{1, 3,3},{2, 4,4},{3, 4,3}};
    // for wightted matrix ----------------
    int graph[n+1][n+1] = {0}; // if it is 1 based 
    for(int i = 0; i < edges.size(); i++){
        int u = edges[i][0];
        int v = edges[i][1];
        int w = edges[i][2];
        graph[u][v] = w;
        graph[v][u] = w;
    }
    // now for adj list 

    vector<pair<int,int>> adj[n+1];
    for(int i = 0; i < n; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        int w = edges[i][2];

        adj[u].push_back({v,w});
        adj[v].push_back({u,w});
    }
    return 0;
}