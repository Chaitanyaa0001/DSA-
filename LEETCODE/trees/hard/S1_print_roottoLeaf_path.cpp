#include <bits/stdc++.h>
using namespace std;

struct Node {
    int val;
    Node* left;
    Node* right;

    Node(int val) {
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};

void solve(Node* root, vector<int>& temp,vector<vector<int>>& ans) {
    if (root == nullptr) {
        return;
    }
    temp.push_back(root->val);
    if (root->left == nullptr && root->right == nullptr) {
        ans.push_back(temp);
        temp.pop_back();
        return;
    }

    solve(root->left, temp, ans);
    solve(root->right, temp, ans);
    temp.pop_back();  // Backtracking
}

vector<vector<int>> print_root_to_leaf(Node* root) {
    vector<vector<int>> ans;
    vector<int> temp;

    solve(root, temp, ans);

    return ans;
}

int main() {
    return 0;
}