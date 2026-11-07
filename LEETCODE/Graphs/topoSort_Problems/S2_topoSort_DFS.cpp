
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

// now using bfs  we can do but thats kahna algo 

vector<int> kahns_algorithm(vector<vector<int>> edges, int V) {
    vector<int> adj[V + 1];
    vector<int> indegree(V + 1, 0);
    for(int i = 0; i < edges.size(); i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
        indegree[v]++;
    }

    queue<int> q;
    for(int i = 1; i < indegree.size(); i++) {
        if(indegree[i] == 0) {
            q.push(i);
        }
    }

    vector<int> ans;
    while(!q.empty()) {
        int curr = q.front();
        q.pop();
        ans.push_back(curr);
        for(int nei : adj[curr]) {
            indegree[nei]--;
            if(indegree[nei] == 0) {
                q.push(nei);
            }
        }
    }
    return ans;
}


int main() {

    return 0;
}
