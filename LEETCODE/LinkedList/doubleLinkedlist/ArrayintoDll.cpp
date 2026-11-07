#include<bits/stdc++.h>
using namespace std;


struct Node{
    /* data */
    int data;
    Node* next;
    Node* back;
    Node(int data){
        this->data = data;
        this->next = nullptr;
        this->back = nullptr;
    }
};

// given an array u need to make a doubly linkedlist with with array 
Node* doublyLinkedList(vector<int> nums){
    if(nums.empty()){
        return nullptr;
    }
    int n = nums.size();
    Node* head = new Node(nums[0]);
    Node* temp = head;
    //  <- 0  ->    <-(node)->
    for(int i = 1; i < n; i++){
        Node* node = new Node(nums[i]);
        temp->next = node;
        node->back  = temp;
        temp = temp->next;
    }
    return head;
}

int main(){
    int n;
    cin >> n;
    vector<int> nums(n);

    for(int i= 0; i < n; i++){
        cin >> nums[i];
    }
    return 0;
}