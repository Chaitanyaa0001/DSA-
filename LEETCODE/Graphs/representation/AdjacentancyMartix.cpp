#include<bits/stdc++.h>
using namespace std;


int main() {
    int n = 5;
    vector<vector<int>> edges = {{0, 1},{0, 2},{1, 2},{1, 3},{2, 4},{3, 4}};
    // now we can build  graph            
    int graph[n+1][n+1] = {0};
    for(int i =  0; i < edges.size(); i++){
        int u = edges[i][0]; 
        int v = edges[i][1]; 
        graph[u][v] = 1;
        graph[v][u] = 1; // for directed grapph we dont write this  as fircted graph is only of onr direction 
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << graph[i][j];
        }
        cout << '\n';
    }
    // 0 1 1 0 0 
    // 1 0 1 1 0 
    // 1 1 0 0 1 
    // 0 1 0 0 1 
    // 0 0 1 1 0
    return 0;
}

