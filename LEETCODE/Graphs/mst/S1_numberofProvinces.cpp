#include<bits/stdc++.h>
using namespace std;

class DisjointSet {
public:
    vector<int> size;
    vector<int> parent;
    DisjointSet(int n) {
        size.resize(n + 1);
        parent.resize(n + 1);

        for(int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    int findparent(int node) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = findparent(parent[node]);
    }
    void unionsize(int u, int v) {
        int ulti_u = findparent(u);
        int ulti_v = findparent(v);
        if(ulti_u == ulti_v)
            return;

        if(size[ulti_u] < size[ulti_v]) {
            parent[ulti_u] = ulti_v;
            size[ulti_v] += size[ulti_u];
        }
        else {
            parent[ulti_v] = ulti_u;
            size[ulti_u] += size[ulti_v];
        }
    }
};
class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        DisjointSet ds(n);
        // Find all connections
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j]) {
                    ds.unionsize(i, j);
                }
            }
        }
        // Count number of components
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(ds.findparent(i) == i) {
                ans++;
            }
        }
        return ans;
    }
};

int main(){
    return 0;
}