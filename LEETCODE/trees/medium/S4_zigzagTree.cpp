#include<bits/stdc++.h>
using namespace std;


struct TreeNode
{
    /* data */
    int data;
    TreeNode* left ;
    TreeNode* right;
    TreeNode(int data){
        this->data = data;
        this->left = nullptr;
        this->right = nullptr;
    }
};

vector<vector<int>> zigzagLevelOrder(TreeNode* root) {

    deque<TreeNode*> dq;

    bool lefttoright  = true;
    dq.push_front(root);
    vector<vector<int>> ans;
    while (!dq.empty()){
        int size = dq.size();
        vector<int> level;
        for(int i = 0; i < size; i++){
            if(!lefttoright){
                auto curr = dq.front();
                dq.pop_front();
                level.push_back(curr->data);
                if(curr->left != nullptr){
                    dq.push_back(curr->left);
                }
                if(curr->right != nullptr){
                    dq.push_back(curr->right);
                }
            }else{
                auto curr = dq.back();
                dq.pop_back();
                level.push_back(curr->data);

                if(curr->right != nullptr){
                    dq.push_front(curr->right);
                }

                if(curr->left != nullptr){
                    dq.push_front(curr->left);
                }
                
            }
        }
        lefttoright = !lefttoright;
        ans.push_back(level);
    }
    return ans;
    
}
int main(){

    return 0;
}