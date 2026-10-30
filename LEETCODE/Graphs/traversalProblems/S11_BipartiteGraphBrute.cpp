
#include <bits/stdc++.h>
using namespace std;

bool bipitet_graph(vector<vector<int>>& edges, int V) {

    vector<vector<int>> adj(V + 1);

    // Create adjacency list
    for (int i = 0; i < edges.size(); i++) {

        int u = edges[i][0];
        int v = edges[i][1];

        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int> color(V + 1, -1);
    // Handle disconnected components
    for (int i = 1; i <= V; i++) {
        if (color[i] != -1) continue;
        queue<int> q;
        q.push(i);
        color[i] = 0;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            for (int nei : adj[node]) {
                // If not coloured
                if (color[nei] == -1) {
                    color[nei] = 1 - color[node];
                    q.push(nei);
                }
                // If same colour as current node
                else if (color[node] == color[nei]) {
                    return false;
                }
            }
        }
    }
    return true;
}

int main() {
    int V = 4;

    vector<vector<int>> edges = {
        {1, 2},
        {2, 3},
        {3, 4},
        {4, 1}
    };

    cout << bipitet_graph(edges, V);

    return 0;
}
