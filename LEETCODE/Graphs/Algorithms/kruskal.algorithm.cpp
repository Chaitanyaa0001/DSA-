#include<bits/stdc++.h>
using namespace std;

class DisjointSet{
public:
    vector<int>size;
    vector<int> parent;
    DisjointSet(int n){
        size.resize(n+1);
        parent.resize(n+1);

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findparent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findparent(parent[node]);
    }

    void unionSize(int u, int v){
        int ult_u = findparent(u);
        int ult_v = findparent(v);
        if(ult_u == ult_v){
            return ;
        }
        if(size[ult_u] < size[ult_v]){
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        }else{
            size[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }
};
int krushkal_algorithm(int V, int E, vector<vector<pair<int, int>>> adj){
    // w,u,v
    vector<pair<int,pair<int,int>>> edges;

    for(int i = 0; i <= V; i++){
        int u = i;
        // pair 
        for(auto edge : adj[i]){
            int v = edge.first;
            int w = edge.second;
            edges.push_back({w,{u,v}});
        }
    }
    sort(edges.begin(), edges.end());
    int weight = 0;

    DisjointSet ds(V);

    for(auto it : edges){
        int w = it.first;
        int u = it.second.first;
        int v = it.second.second;

        if(ds.findparent(u) != ds.findparent(v)){
            weight += w;
            ds.unionSize(u,v);
        } 
    }
    return weight;
}

int main(){
    int V ;cin >> V; // total number of nodes 
    int E; cin >> E; // total number of edges 

    vector<vector<pair<int,int>>> adj(V + 1);

    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;

        adj[u].push_back({v, w});
        adj[v].push_back({u, w});  // for undirected graph
    }

}