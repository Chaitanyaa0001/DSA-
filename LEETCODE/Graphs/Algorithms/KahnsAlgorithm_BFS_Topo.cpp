#include<bits/stdc++.h>
using namespace std;



vector<int> kahns_algorithm(vector<vector<int>> edges, int V) {
    vector<int> adj[V + 1];
    vector<int> indegree(V + 1, 0);
    for(int i = 0; i < edges.size(); i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        adj[u].push_back(v);
        indegree[v]++;
    }

    queue<int> q;
    for(int i = 1; i < indegree.size(); i++) {
        if(indegree[i] == 0) {
            q.push(i);
        }
    }

    vector<int> ans;
    while(!q.empty()) {
        int curr = q.front();
        q.pop();
        ans.push_back(curr);
        for(int nei : adj[curr]) {
            indegree[nei]--;
            if(indegree[nei] == 0) {
                q.push(nei);
            }
        }
    }
    return ans;
}

int main(){

}




