
#include <bits/stdc++.h>
using namespace std;

bool dfs(int node, vector<int> adj[], vector<int>& color) {
    for (int nei : adj[node]) {
        if (color[nei] == -1) {
            color[nei] = 1 - color[node];
            if (!dfs(nei, adj, color)) {
                return false;
            }
        }
        else if (color[nei] == color[node]) {
            return false;
        }
    }
    return true;
}
bool detect_bipilteGraph(vector<vector<int>>& edges, int V) {
    vector<int> adj[V + 1];
    // Build adjacency list
    for (int i = 0; i < edges.size(); i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int> color(V + 1, -1);
    // Handle all components
    for (int i = 1; i <= V; i++) {
        if (color[i] == -1) {
            color[i] = 0;
            if (!dfs(i, adj, color)) {
                return false;
            }
        }
    }
    return true;
}
int main() {
    int V = 3;
    vector<vector<int>> edges = {
        {1, 2},
        {2, 3},
        {3, 1}
    };
    cout << detect_bipilteGraph(edges, V) << endl;
    return 0;
}
