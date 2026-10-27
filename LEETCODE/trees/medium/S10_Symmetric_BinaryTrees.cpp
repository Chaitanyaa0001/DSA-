#include<bits/stdc++.h>
using namespace std;


struct Node{
    int val;
    Node* left;
    Node* right;
    Node(int val){
        this->val = val;
        this->left  = nullptr;
        this->right = nullptr;
    }
};

bool solve(Node* root1, Node* root2){

    if(root1 == nullptr || root2 == nullptr){
        return (root1 == root2);
    }
    return (root1->val == root2->val) && solve(root1->left,root2->right) && solve(root1->right, root2->left);
}
bool symmetric_binary(Node* root) {
    if (root == nullptr) {
        return true;
    }
    return solve(root->left, root->right);
}
int main(){
    return 0;
}