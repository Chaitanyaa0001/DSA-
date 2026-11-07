#include<bits/stdc++.h>
using namespace std;

struct Node{
    int val;
    Node* left;
    Node* right;
    Node(int val){
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};

vector<int> bottom_view(Node* root){
    if (root == nullptr) return {};
    map<int,Node*> mp;
    queue<pair<Node*, int>> q;
    q.push({root,0});
    vector<int> ans;
    while (!q.empty()){
        auto curr = q.front();
        Node* nde = curr.first;
        int c = curr.second;
        q.pop();
        mp[c] = nde;
        if(nde->left!= nullptr){
            q.push({nde->left,c-1});
        }
        if(nde->right != nullptr){
            q.push({nde->right,c+1});
        }
        
    }
    for(auto & it : mp){
        ans.push_back(it.second->val);
    }
    return ans;
}
int main(){

    return 0;
}