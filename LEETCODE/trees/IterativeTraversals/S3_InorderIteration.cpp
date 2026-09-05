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
vector<int> inorder(Node* root){
    stack<Node*> s;

    auto node = root;
    vector<int> ans;

    while (true){
        if(node != nullptr){
            s.push(node);
            node = node->left;
        }else{
            if(s.empty()){
                break;
            }
            node = s.top();
            s.pop();
            ans.push_back(node->val);
            node = node->right;
        }
    }
    
}
int main(){
    return 0;
}