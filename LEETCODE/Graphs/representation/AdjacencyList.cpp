#include <bits/stdc++.h>
using namespace std;

int main() {
    int n = 5;
    int edges[][2] = {{1, 2},{1, 3},{2, 4},{3, 4},{2, 5},{4, 5}};

    // Adjacency List
    vector<int> graph[n+1];
    
    for (int i = 0; i < 6; i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        graph[u].push_back(v);
        graph[v].push_back(u);   // Remove this for directed graph
    }


    return 0;
}