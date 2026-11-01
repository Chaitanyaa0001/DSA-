
#include <bits/stdc++.h>
using namespace std;

void dfs(int node, vector<vector<int>>& adj, stack<int>& st, vector<int>& vis) {

    vis[node] = 1;
    for (int nei : adj[node]) {
        if (!vis[nei]) {
            dfs(nei, adj, st, vis);
        }
    }
    st.push(node);
}
// Works only for DAGs.
vector<int> topo_sort(vector<vector<int>>& edges, int V) {
    vector<vector<int>> adj(V + 1);
    vector<int> vis(V + 1, 0);
    stack<int> st;
    for (auto& edge : edges) {
        int u = edge[0];
        int v = edge[1];
        adj[u].push_back(v);
    }
    for (int i = 1; i <= V; i++) {
        if (!vis[i]) {
            dfs(i, adj, st, vis);
        }
    }
    vector<int> ans;
    while (!st.empty()) {
        ans.push_back(st.top());
        st.pop();
    }
    return ans;
}

int main() {

    return 0;
}
