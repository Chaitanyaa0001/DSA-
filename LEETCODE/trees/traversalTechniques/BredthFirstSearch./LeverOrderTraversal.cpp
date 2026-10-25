#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val) {
        this->data = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};

vector<vector<int>> levelorder(TreeNode* root) {
    vector<vector<int>> ans;
    if(root == nullptr) {
        return ans;
    }
    queue<TreeNode*> q;
    q.push(root);
    vector<vector<int>> levelorder;
    while (!q.empty()){
        int size = q.size();
        vector<int> level;
        for(int i = 0; i < size; i++){
            auto curr = q.front();
            int data = curr->data;
            level.push_back(data);

            if(curr->left != nullptr){
                q.push(curr->left);
            }
            if(curr->right != nullptr){
                q.push(curr->right);
            }
        }
        levelorder.push_back(level);
    }
    

    return levelorder;
}