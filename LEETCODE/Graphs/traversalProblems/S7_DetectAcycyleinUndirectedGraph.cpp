#include <bits/stdc++.h>
using namespace std;

bool dfs(int node, int parent,
         vector<int>& vis,
         vector<vector<int>>& adj) {

    vis[node] = 1;

    for(auto nei : adj[node]) {

        // If neighbor is not visited
        if(vis[nei] == 0) {

            if(dfs(nei, node, vis, adj)) {
                return true;
            }
        }

        // If neighbor is already visited
        // and it is not our parent
        else if(nei != parent) {
            return true;
        }
    }

    return false;
}


bool detectcycle(vector<vector<int>> edges, int V, int m) {
    // Create adjacency list
    vector<vector<int>> adj(V);
    for(int i = 0; i < edges.size(); i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int> vis(V, 0);
    // Handle disconnected graph
    for(int i = 0; i < V; i++) {
        if(vis[i] == 0) {
            if(dfs(i, -1, vis, adj)) {
                return true;
            }
        }
    }
    return false;
}

int main() {
    return 0;
}