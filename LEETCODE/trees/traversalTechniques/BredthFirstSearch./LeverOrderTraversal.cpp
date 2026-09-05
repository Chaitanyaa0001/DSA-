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
    while(!q.empty()) {
        int size = q.size();
        vector<int> level;
        for(int i = 0; i < size; i++) {
            auto curr = q.front();
            q.pop();
            // Add current node to this level
            level.push_back(curr->data);
            if(curr->left != nullptr) {
                q.push(curr->left);
            }
            if(curr->right != nullptr) {
                q.push(curr->right);
            }
        }
        ans.push_back(level);
    }

    return ans;
}