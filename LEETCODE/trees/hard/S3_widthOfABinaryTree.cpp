#include<bits/stdc++.h>
using namespace std;


struct Node
{
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

int width_of_a_binary_tree(Node* root){

    queue<pair<int,Node*>> q;
    q.push({0,root});
    int maxwidth = 0;

    while (!q.empty()){
        int size = q.size();
        int first  = 0;
        int last = 0;
        int mini_index = q.front().first;

        for(int i = 0; i < size; i++){
            auto curr = q.front();
            int index  = curr.first;
            Node* nde = curr.second;
            q.pop();
            index = index - mini_index;
            if(i == 0){
                first = index;
            }
            if(i == size - 1){
                last = index;
            }
            if(nde->left != nullptr){
                q.push({2*index+1,nde->left});
            }
            if(nde->right != nullptr){
                q.push({2*index+2, nde->right});
            }
        }
        maxwidth = max(maxwidth, last - first + 1);
    }
    return maxwidth;
}
int main(){

    return 0;
}