#include<bits/stdc++.h>
using namespace std;


struct Node{
    /* data */
    int val;
    Node* left;
    Node* right;
    Node(int val){
        this->val = val;
        this->left  = nullptr;
        this->right = nullptr;

    }
};

vector<int> rightside(Node* root){
    if (root == nullptr) return {};
    queue<Node*> q;
    q.push(root);
    vector<int> ans;
    while (!q.empty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
            auto curr = q.front();
            int d = curr->val;
            q.pop();
            if(i == size -1){
                ans.push_back(d);
            }
            if(curr->left != nullptr){
                q.push(curr->left);
            }
            if(curr->right != nullptr){
                q.push(curr->right);
            }
        }
    }
    return ans;
}

vector<int> leftview(Node* root){

    if (root == nullptr) return {};
    queue<Node*> q;
    q.push(root);
    vector<int> ans;
    while (!q.empty()){
        int size = q.size();
        for(int i = 0; i < size; i++){
            auto curr = q.front();
            int d = curr->val;
            q.pop();
            if(i == 0){
                ans.push_back(d);
            }
            if(curr->left != nullptr){
                q.push(curr->left);
            }
            if(curr->right != nullptr){
                q.push(curr->right);
            }
        }
    }
    return ans;
}

int main(){

    return 0;
}