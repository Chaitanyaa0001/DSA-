#include<bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* left;
    Node* right;
    Node(int data){
        this->data = data;
    }
};

int postorder(Node* root, vector<int> &ans){
    if(root == nullptr){
        return ;
    }
    postorder(root->left, ans);
    postorder(root->right, ans);
    ans.push_back(root->data);
}
int main(){
    
    return 0;
}