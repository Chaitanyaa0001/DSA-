#include<bits/stdc++.h>
using namespace std;



struct Node{
    /* data */
    int data;
    Node* left;
    Node* right;
    Node(int data){
        this->data = data;
        this->left = nullptr;
        this->right = nullptr;
    }
};

int solve(Node* root){

    if(root == nullptr){
        return 0;
    }
    int left = solve(root->left);
    int right = solve(root->right);

    return 1 + max(left,right);
}
int maxdept(Node* root){

    return solve(root);
}
Node* createTree(int index, vector<int>& nums) {
    
    if (index >= nums.size()) {
        return nullptr;
    }
    Node* parent = new Node(nums[index]);
    parent->left = createTree(2 * index + 1, nums);
    parent->right = createTree(2 * index + 2, nums);
    return parent;
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    createTree(0, nums);
    return 0;
}