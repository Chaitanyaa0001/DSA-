#include<bits/stdc++.h>
using namespace std;

class Node{
public : 
    int data;
    Node* left;
    Node* right;
    Node(int data){
        this->data = data;
        this->left = left;
        this->right = right;
    }
};

int preorder(Node* root, vector<int> &ans){
    if(root == nullptr){
        return ;
    }
    ans.push_back(root->data);
    preorder(root->left, ans);
    preorder(root->right, ans);
}
int main(){
    
    return 0;
}