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
        this->back  = nullptr;
    }
};


Node* insert_at_head(Node* head, int val){
    if(head == nullptr){
        return nullptr;
    }
    Node* newNode = new Node(val);
    newNode->next = head;
    head->back = newNode;
    return newNode;
    
}

Node* insert_at_tail_before(Node* head, int val){
    if(head == nullptr){
        return nullptr;
    }
    Node* temp = head;

    while (temp->next->next != nullptr){
        temp = temp->next;
    }
    Node* newNode = new Node(val);
    newNode->next = temp->next;
    temp->next->back = newNode;
    temp->next = newNode;
    newNode->back = temp;
    // 0 - 0 - 0
            // 0   
    return head;   
}

Node* insert_at_tail_after(Node* head, int val) {
    Node* newNode = new Node(val);

    // Case 1: Empty list
    if (head == nullptr) {
        return newNode;
    }

    Node* temp = head;

    // Reach the last node
    while (temp->next != nullptr) {
        temp = temp->next;
    }

    // Insert after the last node
    temp->next = newNode;
    newNode->back = temp;

    return head;
}

Node* insert_at_kthposition(Node* head, int k, int val) {
    if (k <= 0) {
        return head;
    }

    if (k == 1) {
        Node* temp = new Node(val);
        temp->next = head;

        if (head != nullptr) {
            head->back = temp;
        }

        return temp;
    }

    Node* temp = head;
    int counter = 1;

    while (temp != nullptr) {
        if (counter == k) {
            break;
        }
        counter++;
        temp = temp->next;
    }

    if (temp == nullptr) {
        return head;
    }

    Node* newNode = new Node(val);
    Node* prev = temp->back;

    prev->next = newNode;
    newNode->back = prev;
    newNode->next = temp;
    temp->back = newNode;

    return head;
}
int main(){

    return 0;
}