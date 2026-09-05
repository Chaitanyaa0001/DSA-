#include<bits/stdc++.h>
using namespace std;

struct Node {
    int val;
    Node* left;
    Node* right;
    Node(int val){
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    };
};
vector<int> preorder(Node* root){

    stack<Node*> st;
    st.push(root);
    vector<int> ans;

    while (!st.empty()){
        int size = st.size();
        
        for(int i = 0; i < size; i++){
            auto curr = st.top();
            st.pop();
            ans.push_back(curr->val);
            if(curr->right != nullptr){
                st.push(curr->right);
            }
            if(curr->left != nullptr){
                st.push(curr->right);
            }
        }
    }
    return ans;
}
int main(){
    
}