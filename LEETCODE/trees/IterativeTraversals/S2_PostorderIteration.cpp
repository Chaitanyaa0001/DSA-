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
vector<int> using2stack(Node* root){
    stack<Node*> s1, s2;
    s1.push(root);
    while (!s1.empty()){
        auto curr = s1.top(); s1.pop();
        s2.push(curr);
        if(curr->left != nullptr){
            s1.push(curr->left);
        }

        if(curr->right != nullptr){
            s1.push(curr->right);
        }
    }
    vector<int> ans;
    while (!s2.empty())
    {
        auto ele = s2.top();
        int data = ele->val;
        ans.push_back(data);
        s2.pop();
    }
    return ans;
    
}
int main(){
    
}