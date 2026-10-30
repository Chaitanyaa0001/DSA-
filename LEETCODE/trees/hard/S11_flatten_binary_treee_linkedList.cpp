#include<bits/stdc++.h>
using namespace std;


struct Node{
    /* data */
    int val;
    Node* left;
    Node* right;
    Node(int val){
        this->val = val;
        this->left = left;
        this->right = right;
    }
};

class Solution{
    public:

    void solve(Node* root){
        if(root == nullptr){
            return ;
        }
        Node* prev = nullptr;
        solve(root->right);
        solve(root->left);
        root->right = prev;
        root->left = nullptr;
        prev = root;
    }
    void flatten(Node* root) {
        if(root == nullptr){
            return ;
        }   
    }
};
int main(){

    return 0;
}