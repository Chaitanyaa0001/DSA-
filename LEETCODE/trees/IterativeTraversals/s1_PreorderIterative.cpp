
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

vector<int> preorder(Node* root) {
    // Root -> Left -> Right
    vector<int> preorder_ans;
    if (root == nullptr) return preorder_ans;

    stack<Node*> st;
    st.push(root);

    while (!st.empty()) {
        Node* curr = st.top();
        st.pop();

        preorder_ans.push_back(curr->val);

        // Push right first, then left
        if (curr->right != nullptr) {
            st.push(curr->right);
        }

        if (curr->left != nullptr) {
            st.push(curr->left);
        }
    }

    return preorder_ans;
}

int main() {
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);

    vector<int> ans = preorder(root);

    for (int x : ans) {
        cout << x << " ";
    }

    return 0;
}
