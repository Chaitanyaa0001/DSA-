#include <bits/stdc++.h>
using namespace std;

void bfs(int n, int m, vector<vector<int>>& edges) {
    
    // Create adjacency list
    vector<vector<int>> adj(n + 1);
    for(int i = 0; i < m; i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    // Visited array
    vector<int> vis(n + 1, 0);
    // Queue
    queue<int> q;
    q.push(1);
    vis[1] = 1;
    while(!q.empty()) {
        int curr = q.front();
        q.pop();
        cout << curr << " ";
        for(auto nei : adj[curr]) {
            if(vis[nei] == 0) {
                vis[nei] = 1;
                q.push(nei);
            }
        }
    }
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
    bfs(n, m, edges);

    return 0;
}