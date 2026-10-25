
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        this->data = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};

vector<int> inorder(Node* root) {
    stack<Node*> st;
    Node* curr = root;
    vector<int> ans;

    while (curr != nullptr || !st.empty()) {
        if (curr != nullptr) {
            st.push(curr);
            curr = curr->left;
        } else {
            curr = st.top();
            st.pop();
            ans.push_back(curr->data);
            curr = curr->right;
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

    vector<int> ans = inorder(root);

    for (int x : ans) {
        cout << x << " ";
    }

    return 0;
}
