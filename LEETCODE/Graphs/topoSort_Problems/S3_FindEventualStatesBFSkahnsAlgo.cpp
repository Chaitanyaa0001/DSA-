#include<bits/stdc++.h>
using namespace std;


// in this we need to figure out   weather our node is safe or not if every pasth leads to terminal nodes 

bool dfs(int node,vector<int>& ans, vector<int>& vis, vector<int>& pathvis,vector<int> adj[]){
    vis[node] = true;
    pathvis[node] = true;
    for(int nei : adj[node]){
        if(!vis[nei]){
            if(dfs(nei,ans,vis,pathvis,adj)){
                return true;
            }
        }else if(pathvis[nei]){
            return true;
        }
    }
    ans.push_back(node);
    pathvis[node] = false;
    return false;
}
vector<int> find_safe_states(vector<vector<int>> edges, int V){
    vector<int> adj[V+1];
    vector<int> indegree(V+1);
    for(int  i = 0; i < V; i++){
        int u = edges[i][0];
        int v = edges[i][1];

        adj[u].push_back(v);
        indegree[v]++;
    }    
    vector<int> vis(V+1);
    vector<int> pathvis(V+1);
    vector<int> ans;
   

}
int main(){

    return 0;
}