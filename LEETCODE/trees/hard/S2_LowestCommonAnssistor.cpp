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
Node* solve(Node* root ,Node* p, Node* q){


    if(root == nullptr){
        return  root;
    }
    if(p->val == root->val || q->val == root->val){
        return root;
    }

    Node* left  = solve(root->left,p,q);
    Node* right = solve(root->right,p,q);

    if(left == nullptr){
        return right;
    }else if(right == nullptr){
        return left;
    }else{
        return root;
    }

}
Node* lowest_common_ansistor(Node* root, Node* p, Node* q){
    return solve(root,p,q);
}
int main(){

    return 0;
}