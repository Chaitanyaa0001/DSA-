#include<bits/stdc++.h>
using namespace std;


bool bfs(vector<vector<int>> edges, int V, int m, int src){
// using bfs 
    // create adj list 
    vector<vector<int>> adj(V);

    for(int i = 0; i < m; i++){
        int u = edges[i][0];
        int v = edges[i][1];

        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    queue<pair<int,int>> q; 
    q.push({src,-1});
    vector<int> vis(V);

    while (!q.empty()){
        auto curr = q.front();
        int node = curr.first;
        int parent = curr.second;
        q.pop();

        for(auto nei : adj[node]){
            if(vis[nei] == 0){
                vis[nei] = 1;
                q.push({nei,node});
            }else if(nei != parent){
                return true;
            }
        }
    }
    return false;
    
}
int main(){

    return 0;
}