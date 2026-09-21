#include<bits/stdc++.h>
using namespace std;

void bfs(int node, vector<vector<int>>& adj, vector<int>& vis) {
    queue<int> q;
    q.push(node);
    vis[node] = 1;
    while(!q.empty()) {
        int curr = q.front();
        q.pop();
        for(auto nei : adj[curr]) {
            if(!vis[nei]) {
                vis[nei] = 1;
                q.push(nei);
            }
        }
    }
}

int connectedComponents(vector<vector<int>>& edges, int v, int m){
    vector<vector<int>> adj(v+1);
    for(int i = 0; i < m; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int> vis(v,0); // its will be 0 based nodes
    int count = 0;
    for(int i = 0;  i < v; i++){
        if(vis[i] == 0){
            count++;
            bfs(i,adj,vis);
        }
    }
}
int main(){
    int n;
    int m;

    cin >> n >> m;
    vector<vector<int>> edges(m,vector<int>(2));
    for(int i = 0; i < m; i++){
        for(int j = 0; i < 2; j++){
            cin >>  edges[i][j];
        }
    }
}