#include<bits/stdc++.h>
using namespace std;



struct Node
{
    /* data */
    int data;
    Node* left;
    Node* right;
    Node(int data){
        this->data = data;
        this->left =  nullptr;
        this->right = nullptr;
    }
};

vector<int> postorder(Node* root){
    stack<Node*> s1;
    stack<Node*> s2;

    s1.push(root);
    while (s1.empty()){
        /* code */
        auto curr = s1.top(); s1.pop();
        s2.push(curr);
        if(curr->left != nullptr){
            s1.push(curr->left);
        }
        if(curr->right != nullptr){
            s1.push(curr->right);
        }
    }
    

}
int main(){

}