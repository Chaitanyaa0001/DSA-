#include<bits/stdc++.h>
using namespace std;



void kahns_algorithm(vector<vector<int>> edges, int V){
    vector<int> adj[V+1];
    for(int i = 0; i < edges.size(); i++){
        int u = edges[i][0];
        int v = edges[i][1];

        adj[u].push_back(v);
        adj[v].push_back(u);
    } 
    // now we have to perform this bfs 
    // if graph is one based then v+1 if 0 based then obly V 
    vector<int> indegree(V);
    for(int i = 0; i < )
}

    int main(){

}




