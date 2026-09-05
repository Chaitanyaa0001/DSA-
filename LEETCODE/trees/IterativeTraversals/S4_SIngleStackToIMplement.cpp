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
void allinone(Node* root) {
    vector<int> preorder;
    vector<int> inorder;
    vector<int> postorder;
    if(root == nullptr) return;
    stack<pair<int, Node*>> s;

    s.push({1, root});
    while(!s.empty()) {
        auto it = s.top();
        s.pop();

        int state = it.first;
        Node* node = it.second;
        // State 1 → Preorder
        if(state == 1) {
            preorder.push_back(node->val);
            // Change state to 2
            s.push({2, node});
            // Go left
            if(node->left != nullptr) {
                s.push({1, node->left});
            }
        }else if(state == 2) {
            inorder.push_back(node->val);
            // Change state to 3
            s.push({3, node});
            // Go right
            if(node->right != nullptr) {
                s.push({1, node->right});
            }
        }
        // State 3 → Postorder
        else {
            postorder.push_back(node->val);
        }
    }
    cout << "Preorder: ";
    for(int x : preorder)
        cout << x << " ";

    cout << "\nInorder: ";
    for(int x : inorder)
        cout << x << " ";

    cout << "\nPostorder: ";
    for(int x : postorder)
        cout << x << " ";
}

int main() {

    Node* root = new Node(1);

    root->left = new Node(2);
    root->right = new Node(3);

    root->left->left = new Node(4);
    root->left->right = new Node(5);

    root->right->left = new Node(6);
    root->right->right = new Node(7);

    allinone(root);

    return 0;
}