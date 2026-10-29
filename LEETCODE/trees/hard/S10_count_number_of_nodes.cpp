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
// bruetofrce
int bruteforc(Node* root, int& count){
    if(root == nullptr){
        return 0;
    }
    count++;
    bruteforc(root->left, count);
    bruteforc(root->right, count);
    return count;
}

// optimal 
int left_height(Node* root){
    Node* curr  = root;
    int count = 0;
    while (curr != nullptr){
        /* code */
        count++;
        curr = curr->left;   
    }
    return count;
}
int rigt_count(Node* root){
    Node* curr = root;
    int count = 0;
    while (curr != nullptr){
        /* code */
        count++;
        curr = curr->right;
    }
    return count;
}

int count_complete_tree_Nodes(Node* root){

    if(root == nullptr){
        return 0;
    }
    int left = left_height(root);
    int right  = rigt_count(root);
    if(left == right){
        return pow(2,left) - 1;
    }else{
        return 1 + count_complete_tree_Nodes(root->left) + count_complete_tree_Nodes(root->right);
    }
}
int main(){

    return 0;
}