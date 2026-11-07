
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int data) {
        this->data = data;
        this->left = nullptr;
        this->right = nullptr;
    }
};

int solve(Node* root, int& maxi) {
    if (root == nullptr) {
        return 0;
    }

    int left = solve(root->left, maxi);
    int right = solve(root->right, maxi);

    maxi = max(maxi, left + right);

    return 1 + max(left, right);
}

int diameterOfBinaryTree(Node* root) {
    int maxi = 0;
    solve(root, maxi);
    return maxi;
}

int main() {
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);

    cout << diameterOfBinaryTree(root) << '\n';

    return 0;
}
