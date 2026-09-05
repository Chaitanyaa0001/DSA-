#include<bits/stdc++.h>
using namespace std;

class DisjointSet{
public:
    vector<int> rank;
    vector<int> parent;
    vector<int> size;
    DisjointSet(int n){
        rank.resize(n+1); // it its one based indexing
        parent.resize(n+1);
        size.resize(n + 1);
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
    };
    // by rank 
    void unionByrank(int u, int v){
        int ultimate_parent_of_u = findparent(u);
        int ultimate_parent_v = findparent(v);

        if(ultimate_parent_of_u == ultimate_parent_v) return ;

        if(rank[ultimate_parent_of_u] < rank[ultimate_parent_v]){
            parent[ultimate_parent_of_u] = ultimate_parent_v;
        }else if(rank[ultimate_parent_v] < rank[ultimate_parent_of_u]){
            parent[ultimate_parent_v] = ultimate_parent_of_u;
        }else{
            parent[ultimate_parent_of_u] = ultimate_parent_v;
            rank[ultimate_parent_v]++;
        }
    }    
    // by size 
    void unionBysize(int u, int v){
        int ultimate_parent_of_u = findparent(u);
        int ultimate_parent_of_v = findparent(v);

        if(ultimate_parent_of_u == ultimate_parent_of_v) return ;

        if(size[ultimate_parent_of_u] < size[ultimate_parent_of_v]){
            parent[ultimate_parent_of_u] =  ultimate_parent_of_v;
            size[ultimate_parent_of_v] += size[ultimate_parent_of_u];

        }else if(size[ultimate_parent_of_v] < size[ultimate_parent_of_u]){
            parent[ultimate_parent_of_v] = ultimate_parent_of_u;
            size[ultimate_parent_of_u] += size[ultimate_parent_of_v];
        }else{
            parent[ultimate_parent_of_u] = ultimate_parent_of_v;
            size[ultimate_parent_of_v] += size[ultimate_parent_of_u];

        }
    }
   
};


int main(){

    DisjointSet ds(7);
    ds.unionBysize(1,2);
    ds.unionBysize(2,3);
    ds.unionBysize(4,5);
    ds.unionBysize(6,7);
    ds.unionBysize(5,6);
    

    
}