#include<bits/stdc++.h>
using namespace std;

void dfs(int node,int time, vector<vector<int>> adj, vector<int> vis,vector<int>& insertion_time,vector<int>& lowest_insertion_time){
    vis[node] = 1;
    for(auto nei : adj[node]){
        if(vis[nei] == 0){
            dfs(nei,time+1,adj,vis,insertion_time,lowest_insertion_time);
        }else {
            if( nei != node && lowest_insertion_time[nei] <  lowest_insertion_time[node]){
                lowest_insertion_time[nei] = lowest_insertion_time[node]
            }
        }
    }
}
vector<vector<int>> tarjansAlgo(int V, vector<vector<int>> edges){
    vector<vector<int>> adj(V);
    for(int i = 0; i < V; i++){
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int> vis(V,0);
    vector<int> insertion_time(V,0);
    vector<int> lowest_insertion_time(V,0);
    for(int i = 0; i < V; i++){
        if(vis[i] == 0){
            dfs(i,time,adj,vis,insertion_time,lowest_insertion_time);
        }
    }
}

int main(){

    return 0;
}