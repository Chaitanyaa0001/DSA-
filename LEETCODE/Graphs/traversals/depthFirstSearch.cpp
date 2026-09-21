#include <bits/stdc++.h>
using namespace std;

void calldfs(int node, vector<vector<int>>& adj, vector<int>& vis) {
    vis[node] = 1;
    for(auto nei : adj[node]) {
        if(vis[nei] == 0) {
            calldfs(nei, adj, vis);
        }
    }
}

void dfs(vector<vector<int>>& edges, int n, int m) {

    // Create adjacency list
    vector<vector<int>> adj(n + 1);

    for(int i = 0; i < edges.size(); i++) {

        int u = edges[i][0];
        int v = edges[i][1];

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // Visited array
    vector<int> vis(n + 1, 0);

    // Start DFS from node 1
    calldfs(1, adj, vis);
}

int main() {

    int n, m;
    cin >> n >> m;

    vector<vector<int>> edges(m, vector<int>(2));

    for(int i = 0; i < m; i++) {
        for(int j = 0; j < 2; j++) {
            cin >> edges[i][j];
        }
    }

    dfs(edges, n, m);

    return 0;
}