#include <bits/stdc++.h>
using namespace std;

bool dfs(int node, vector<int> adj[],vector<int>& vis, vector<int>& pathVis) {
    vis[node] = 1;
    pathVis[node] = 1;
    for (int nei : adj[node]) {
        if (!vis[nei]) {
            if (dfs(nei, adj, vis, pathVis)) {
                return true;
            }
        }
        else if (pathVis[nei]) {
            return true;
        }
    }
    pathVis[node] = 0;
    return false;
}
bool detect_a_cycle_in_directed_graph(vector<vector<int>>& edges, int V) {
    vector<int> adj[V];
    for (auto& e : edges) {
        int u = e[0];
        int v = e[1];
        adj[u].push_back(v);  // Directed edge only
    }
    vector<int> vis(V, 0);
    vector<int> pathVis(V, 0);
    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            if (dfs(i, adj, vis, pathVis)) {
                return true;
            }
        }
    }
    return false;
}

int main() {
    return 0;
}