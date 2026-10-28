#include<bits/stdc++.h>
using namespace std;


struct Node{
    int val;
    Node* left;
    Node* right;

    Node(int val){
        this->val = val;
        this->left = nullptr;
        this->right  = nullptr;
    }
};

void storeParent(Node* root, unordered_map<Node*, Node*>& map){
    if(root == nullptr){
        return;
    }
    if(root->left != nullptr ){   
        map[root->left] = root;
    }
    if(root->right != nullptr){
        map[root->right] = root;
    }
    storeParent(root->left,map);
    storeParent(root->right, map);
}

Node* gettarget(Node* root, int target){
    if(root == nullptr){
        return nullptr;
    }
    if(root->val == target){
        return root;
    }
    Node* left =  gettarget(root->left, target);
    if(left != nullptr){
        return left;
    }

    return gettarget(root->right,target);
}
vector<int> distanceK(Node* root, int target, int k) {

    unordered_map<Node*,Node*> parent;
    storeParent(root,parent);

    queue<Node*> q;
    
    unordered_set<Node* > visited;
    Node* t = gettarget(root, target);
    q.push(t);
    visited.insert(t);
    if (t == nullptr) {
        return {};
    }

    int dis = 0;
    while (!q.empty()){
        int size = q.size();
        if(dis == k){
            break;
        }
        for(int  i = 0; i < size; i++){
            auto curr = q.front(); q.pop();
            if(curr->left != nullptr &&  visited.contains(curr->left) == false){
                q.push(curr->left);
                visited.insert(curr->left);
            }
            if(curr->right != nullptr &&  visited.contains(curr->right) == false){
                q.push(curr->right);
                visited.insert(curr->right);
            }
            if(parent.contains(curr)){
                Node* p = parent[curr];
                if(!visited.contains(p)){
                    q.push(p);
                    visited.insert(p);
                }
            }
        }
        dis++;
    }
    vector<int> ans;
    while (!q.empty()){
        ans.push_back(q.front()->val);
        q.pop();
    }
    return ans;
}

int main(){
    
    return 0;
}