#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int val) {
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};

void changeTree(TreeNode* root) {
    if (root == nullptr) {
        return;
    }

    int childSum = 0;
    if (root->left != nullptr) {
        childSum += root->left->val;
    }
    if (root->right != nullptr) {
        childSum += root->right->val;
    }
    if (childSum >= root->val) {
        root->val = childSum;
    }else {
        if (root->left != nullptr) {
            root->left->val = root->val;
        }
        if (root->right != nullptr) {
            root->right->val = root->val;
        }
    }
    changeTree(root->left);
    changeTree(root->right);
    int total = 0;
    if (root->left != nullptr) {
        total += root->left->val;
    }
    if (root->right != nullptr) {
        total += root->right->val;
    }
    if (root->left != nullptr || root->right != nullptr) {
        root->val = total;
    }
}

int main() {
    return 0;
}