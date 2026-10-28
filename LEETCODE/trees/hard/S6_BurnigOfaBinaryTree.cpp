#include<bits/stdc++.h>
using namespace std;


struct Node{
    /* data */
    int val;
    Node* left;
    Node* right;
    Node(int val){
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};
// Given the root of a binary tree and a target node, find the minimum time
//  required to burn the entire tree if the target node is set on fire. 
//  In one second, the fire spreads from a node to its left child, right child, and parent.

// Note: The tree contains unique values.

// Examples : 

// Input: root = [1, 2, 3, 4, 5, 6, 7], target = 2
  
// Output: 3
// Explanation: Initially 2 is set to fire at 0 sec 
// At 1 sec: Nodes 4, 5, 1 catches fire.
// At 2 sec: Node 3 catches fire.
// At 3 sec: Nodes 6, 7 catches fire.
// It takes 3s to burn the complete tree.
void find_parent(Node* root, unordered_map<Node*, Node*>& parent){

    if(root == nullptr){
        return ;
    }
    if(root->left != nullptr){
        parent[root->left] = root;
    }
    if(root->right != nullptr){
        parent[root->right] = root;
    }
    find_parent(root->left,parent);
    find_parent(root->right, parent);
}

Node* find_target(Node* root, int target){
    if(root == nullptr){
        return nullptr;
    }
    if(root->val == target){
        return root;
    }
    Node* left = find_target(root->left, target);
    if(left != nullptr){
        return left;
    }
    
    return find_target(root->right, target);
}

int buring_of_node(Node* root, int target){    
    unordered_map<Node*, Node*> parent;
    find_parent(root,parent);
    Node* tartegtNode = find_target(root, target);
    queue<Node*> q;
    q.push(tartegtNode);
    int time = 0;
    int min_time = -1;
    unordered_set<Node*> vis;
    vis.insert(tartegtNode);
    q.push(tartegtNode);

    bool burn = false;
    while (!q.empty()){
        int  n = q.size();
        for(int i = 0; i > n; i++){
            Node* curr = q.front();
            q.pop();

            if(curr->left != nullptr && !vis.contains(curr->left)){
                q.push(curr->left);
                vis.insert(curr->left);
                burn = true;
            }
            if(curr->right != nullptr && !vis.contains(curr->right)){
                q.push(curr->right);
                vis.insert(curr->right);
                burn = true;
            }
            if(parent.contains(curr)){
                Node* p = parent[curr];
                if(!vis.contains(p)){
                    q.push(p);
                    vis.insert(p);
                    burn = true;
                }
            }
        }
        if(burn){
            time++;
        }
    }
    return time;    
}

int main(){

}