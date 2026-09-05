#include<bits/stdc++.h>
using namespace std;

void dfs(int node, vector<int> &vis, vector<vector<int>> &adj, stack<int> &st){
    vis[node] = 1;

    for(auto nei : adj[node]){
        if(!vis[nei]){
            dfs(nei,vis,adj,st);
        }
    }
    st.push(node);
}
vector<int> dfs2(int node, vector<vector<int>>& rev, vector<int>& vis, vector<int>& temp){
    vis[node] = 1;

    for(auto nei : rev[node]){
        if(vis[nei] == 0){
            dfs2(nei,rev, vis, temp);
        }
    }
    temp.push_back(node);

}
vector<vector<int>> kosaraju(int V, vector<vector<int>> edges){

    // first make adj list 
    vector<vector<int>>adj(V);
    for(int i = 0 ; i < edges.size(); i++){
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
    }
    // now dfs 1 for  to store in stack
    vector<int> vis(V);
    stack<int> st; 

    for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            dfs(i, vis, adj, st);
        }
    }

    // now reverse the edges 
    vector<vector<int>> rev(V);

    for(int u = 0; u < V; u++){
        for(auto v : adj[u]){
            rev[v].push_back(u);
        }
    }

    fill(vis.begin(), vis.end(), 0);
    vector<vector<int>> ans;

    while (!st.empty()){
        int el = st.top();st.pop();
        
        if(vis[el] == 0){
            vector<int> temp;
            auto res = dfs2(el,rev, vis, temp);
            ans.push_back(res);
        }
    }
    return ans;
}
int main(){
    int  V; 
    cin >> V;
    vector<vector<int>>edges;
    return 0;
}