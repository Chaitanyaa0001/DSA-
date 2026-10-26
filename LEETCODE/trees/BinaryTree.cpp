
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

Node* createTree(const vector<int>& nums, int i) {
    if (i >= nums.size()) {
        return nullptr;
    }

    Node* root = new Node(nums[i]);

    root->left = createTree(nums, 2 * i + 1);
    root->right = createTree(nums, 2 * i + 2);

    return root;
}

int main() {
    vector<int> nums = {1, 2, 3, 4, 5, 6, 7};

    Node* root = createTree(nums, 0);
    return 0;
}
