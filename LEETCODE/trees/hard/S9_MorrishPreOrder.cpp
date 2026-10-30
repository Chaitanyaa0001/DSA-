
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int data) {
        this->data = data;
        left = nullptr;
        right = nullptr;
    }
};

vector<int> moris_traversal(Node* root) {
    Node* curr = root;
    vector<int> ans;

    while (curr != nullptr) {
        // Case 1: No left subtree
        if (curr->left == nullptr) {
            ans.push_back(curr->data);
            curr = curr->right;
        }
        else {
            // Find the inorder predecessor
            Node* temp = curr->left;

            while (temp->right != nullptr &&
                   temp->right != curr) {
                temp = temp->right;
            }

            // Case 2: Create thread
            if (temp->right == nullptr) {
                ans.push_back(curr->data);
                temp->right = curr;
                curr = curr->left;
            }
            // Case 3: Remove thread and visit
            else {
                temp->right = nullptr;
                curr = curr->right;
            }
        }
    }

    return ans;
}

int main() {
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);

    vector<int> ans = moris_traversal(root);

    for (int x : ans) {
        cout << x << " ";
    }

    cout << '\n';
    return 0;
}
