#include<bits/stdc++.h>
using namespace std;


struct Node{
    /* data */
    int data;
    Node* left;
    Node* right;
    Node(int data){
        this->data = data;
        this->left = nullptr;
        this->right = nullptr;
    }
};

int  balancedTree(Node* root){
    if(root == nullptr){
        return 0;
    }
    int left  = balancedTree(root->left);
    if(left  == -1) return -1;
    int right = balancedTree(root->right);
    if(right == -1) return -1;
    if(abs(left - right) > 1){
        return -1;
    }

    return 1 + max(left, right);
}

bool balance_check(Node* root){
    return balancedTree(root) != -1;
}

int main(){

    return 0;
}