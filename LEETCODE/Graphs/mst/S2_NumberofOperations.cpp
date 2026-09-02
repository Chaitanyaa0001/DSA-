#include<bits/stdc++.h>
using namespace std;

class DisjointSet{
public:
    vector<int> size;
    vector<int> parent;
    DisjointSet(int n){
        size.resize(n);
        parent.resize(n);
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    int fp(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = fp(parent[node]);
    }
    void unionsize(int u, int v){
        int ulu = fp(u);
        int ulv = fp(v);
        if(ulu == ulv){
            return ;
        }
        if(size[ulu] < size[ulv]){
            parent[ulu] = ulv;
            size[ulv]  += size[ulu];
        }else{
            parent[ulv] = ulu;
            size[ulu]  += size[ulv];
        }
    }
};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        DisjointSet ds(n);
        int extra = 0;
        // O(n+ E) * 4a
        for(int i = 0; i < connections.size(); i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.fp(u) != ds.fp(v)){
                O(4 alpha)
                ds.unionsize(u,v);
            }else{
                extra++;
            }
        }
        int comp = 0;
        for(int i = 0; i < n; i++){
            if(ds.fp(i) == i){
                comp++;
            }
        }

        int o = comp - 1;
        if(extra >= o){
            return o;
        }
        return -1;
    }
};