
#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int data) {
        this->data = data;
        this->left = nullptr;
        this->right = nullptr;
    }
};

bool isleaf(TreeNode* root) {
    return root != nullptr && root->left == nullptr && root->right == nullptr;
}

void left(TreeNode* root, vector<int>& temp) {
    TreeNode* curr = root->left;

    while (curr != nullptr) {
        if (!isleaf(curr)) {
            temp.push_back(curr->data);
        }
        if (curr->left != nullptr) {
            curr = curr->left;
        } else {
            curr = curr->right;
        }
    }
}

void leafnodes(TreeNode* root, vector<int>& temp) {
    if (root == nullptr) return;
    if (isleaf(root)) {
        temp.push_back(root->data);
        return;
    }
    leafnodes(root->left, temp);
    leafnodes(root->right, temp);
}
void right(TreeNode* root, vector<int>& temp) {
    TreeNode* curr = root->right;
    stack<int> s;
    while (curr != nullptr) {
        if (!isleaf(curr)) {
            s.push(curr->data);
        }
        if (curr->right != nullptr) {
            curr = curr->right;
        } else {
            curr = curr->left;
        }
    }
    while (!s.empty()) {
        temp.push_back(s.top());
        s.pop();
    }
}
vector<int> boundary(TreeNode* root) {
    vector<int> res;
    if (root == nullptr) return res;
    if (!isleaf(root)) {
        res.push_back(root->data);
    } else {
        res.push_back(root->data);
        return res;
    }

    left(root, res);
    leafnodes(root, res);
    right(root, res);
    return res;
}

int main() {
    return 0;
}
