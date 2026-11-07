#include<bits/stdc++.h>
using namespace std;


struct Node{
    int data;
    Node* next;
    Node(int data){
        this->data = data;
        this->next = nullptr;
    }
};

Node* createLinkeList(vector<int> nums, int n){
    Node* head = new Node(nums[0]);
    Node* temp = head;
    for(int i  = 1; i < n; i++){
        Node* newNode = new Node(nums[i]);
        temp->next = newNode;
        temp = newNode;
    }
    return head;
}

void print_list(Node* head){
    Node* temp = head;

    while (temp != nullptr)
    {
        /* code */
        cout << temp->data << " ";
        temp = temp->next;
    }
    
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i= 0;i < n; i++){
        cin >> nums[i];
    }

    return 0;
}